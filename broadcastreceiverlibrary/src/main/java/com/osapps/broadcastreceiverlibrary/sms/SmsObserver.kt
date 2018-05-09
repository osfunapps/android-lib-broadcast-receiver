package com.osapps.broadcastreceiverlibrary.sms


import com.osapps.broadcastreceiverlibrary.generic.BroadcastObserver

/**
 * Created by osapps on 07/05/2018.
 */
interface SmsObserver : BroadcastObserver {
    fun onNewSms(newSmsObj: NewSmsArray)
}
