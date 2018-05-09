package com.osapps.broadcastreceiverlibrary.sms.exceptions

/**
 * Created by osapps on 09/05/2018.
 */
class SmsNoBundleException : SmsException() {

    override val errorMsg: String
        get() = "sms bundle is null"
}
