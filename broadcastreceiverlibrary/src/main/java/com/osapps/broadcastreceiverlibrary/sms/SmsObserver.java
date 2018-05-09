package com.osapps.broadcastreceiverlibrary.sms;


import com.osapps.broadcastreceiverlibrary.generic.BroadcastObserver;

/**
 * Created by osapps on 07/05/2018.
 */
public interface SmsObserver extends BroadcastObserver {
    void onNewSms(NewSmsArray newSmsObj);
}
