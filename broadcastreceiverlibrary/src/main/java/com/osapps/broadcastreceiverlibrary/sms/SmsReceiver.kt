package com.osapps.broadcastreceiverlibrary.sms

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.support.annotation.RequiresApi
import android.telephony.SmsMessage

import com.osapps.broadcastreceiverlibrary.generic.BroadcastReceiver
import com.osapps.broadcastreceiverlibrary.sms.exceptions.SmsNoBundleException
import com.osapps.broadcastreceiverlibrary.sms.exceptions.SmsPdusException

import java.util.Arrays

/**
 * Created by osapps on 07/05/2018.
 */

/**
 * A simple sms receiver.
 *
 * Before you instantiate it, make sure you have all of the necessary permissions in your manifest
 * file.
 * PLUS, to support Marshmallow api and higher, the user will need to consent to a runtime permission.
 *
 * You can read all about it here:
 *
 * https://android.jlelse.eu/detecting-sending-sms-on-android-8a154562597f
 *
 * To use, just inject the receiver and subscribe the observers to it.
 */
class SmsReceiver : BroadcastReceiver<SmsObserver, NewSmsArray>() {

    //todo: This method might not work for lower then api 19 devices. Need an intent filter for api < 19
    override val intentFilterName: String
        @SuppressLint("InlinedApi")
        get() = Telephony.Sms.Intents.SMS_RECEIVED_ACTION


    override fun notifyObserver(observer: SmsObserver, broadcastObj: NewSmsArray) {
        observer.onNewSms(broadcastObj)
    }

    override fun extractIntent(intent: Intent): NewSmsArray {

        val newSmsObjs: NewSmsArray
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            newSmsObjs = fetchKitKatAndUp(intent)
        else
            newSmsObjs = fetchKitKatAndDown(intent)


        return newSmsObjs
    }

    private fun fetchKitKatAndDown(intent: Intent): NewSmsArray {
        val smsBundle = intent.extras ?: //todo: can the bundle be null?
        throw SmsNoBundleException()

        val pdus = smsBundle.get("pdus") as Array<*> ?: throw SmsPdusException()

        val newSmsObjs = NewSmsArray()
        for (pdu in pdus) newSmsObjs.add(SmsMessage.createFromPdu(pdu as ByteArray))
        return newSmsObjs
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private fun fetchKitKatAndUp(intent: Intent): NewSmsArray {
        val newSmsArray = NewSmsArray()
        newSmsArray.addAll(Arrays.asList(*Telephony.Sms.Intents.getMessagesFromIntent(intent)))
        return newSmsArray
    }
}
