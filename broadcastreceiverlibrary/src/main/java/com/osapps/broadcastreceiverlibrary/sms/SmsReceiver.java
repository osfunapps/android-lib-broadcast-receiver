package com.osapps.broadcastreceiverlibrary.sms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.RequiresApi;
import android.telephony.SmsMessage;

import com.osapps.broadcastreceiverlibrary.generic.BroadcastReceiver;
import com.osapps.broadcastreceiverlibrary.sms.exceptions.SmsNoBundleException;
import com.osapps.broadcastreceiverlibrary.sms.exceptions.SmsPdusException;

import java.util.Arrays;

/**
 * Created by osapps on 07/05/2018.
 */
public class SmsReceiver extends BroadcastReceiver<SmsObserver, NewSmsArray> {


    @Override
    protected void notifyObserver(SmsObserver observer, NewSmsArray object) {
        observer.onNewSms(object);
    }

    @Override
    protected NewSmsArray extractIntent(Intent intent) {

        NewSmsArray newSmsObjs;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            newSmsObjs = fetchKitKatAndUp(intent);
        else
            newSmsObjs = fetchKitKatAndDown(intent);


        return newSmsObjs;
    }

    private NewSmsArray fetchKitKatAndDown(Intent intent) {
        Bundle smsBundle = intent.getExtras();
        if (smsBundle == null)  //todo: can the bundle be null?
            throw new SmsNoBundleException();

        Object[] pdus = (Object[]) smsBundle.get("pdus");
        if (pdus == null)
            throw new SmsPdusException();

        NewSmsArray newSmsObjs = new NewSmsArray();
        for (Object pdu : pdus) newSmsObjs.add(SmsMessage.createFromPdu((byte[]) pdu));
        return newSmsObjs;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private NewSmsArray fetchKitKatAndUp(Intent intent) {
        NewSmsArray newSmsArray = new NewSmsArray();
        newSmsArray.addAll(Arrays.asList(Telephony.Sms.Intents.getMessagesFromIntent(intent)));
        return newSmsArray;
    }

    //todo: This method might not work.
    //Need an intent filter for api < 19.
    @SuppressLint("InlinedApi")
    @Override
    protected String getIntentFilterName() {
        return Telephony.Sms.Intents.SMS_RECEIVED_ACTION;
    }
}
