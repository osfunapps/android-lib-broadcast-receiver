package com.osapps.broadcastreceiverlibrary.sms.exceptions

/**
 * Created by osapps on 09/05/2018.
 */
class SmsPdusException : SmsException() {

    override val errorMsg: String
        get() = "sms pdus is null"
}
