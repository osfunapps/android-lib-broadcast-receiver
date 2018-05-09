package com.osapps.broadcastreceiverlibrary.sms.exceptions;

/**
 * Created by osapps on 09/05/2018.
 */
public class SmsNoBundleException extends SmsException {

    @Override
    protected String getErrorMsg() {
        return "sms bundle is null";
    }
}
