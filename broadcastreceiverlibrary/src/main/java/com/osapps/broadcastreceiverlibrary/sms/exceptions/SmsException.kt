package com.osapps.broadcastreceiverlibrary.sms.exceptions

/**
 * Created by osapps on 09/05/2018.
 */
abstract class SmsException : RuntimeException() {

    protected abstract val errorMsg: String
    override val message: String?
        get() = errorMsg

}
