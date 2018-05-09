package com.osapps.broadcastreceiverlibrary.sms.exceptions;

/**
 * Created by osapps on 09/05/2018.
 */
public abstract class SmsException extends RuntimeException {

    @Override
    public String getMessage() {
        return getErrorMsg();
    }

    protected abstract String getErrorMsg();

}
