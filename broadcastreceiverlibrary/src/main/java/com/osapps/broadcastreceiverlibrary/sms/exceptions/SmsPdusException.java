package com.osapps.broadcastreceiverlibrary.sms.exceptions;

/**
 * Created by osapps on 09/05/2018.
 */
public class SmsPdusException extends SmsException {

    @Override
    protected String getErrorMsg() {
        return "sms pdus is null";
    }
}
