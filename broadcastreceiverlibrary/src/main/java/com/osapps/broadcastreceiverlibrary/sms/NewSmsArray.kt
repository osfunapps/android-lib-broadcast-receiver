package com.osapps.broadcastreceiverlibrary.sms

import android.telephony.SmsMessage


import com.osapps.broadcastreceiverlibrary.generic.BroadcastObj

import java.util.ArrayList

/**
 * Created by osapps on 09/05/2018.
 */

//this object meant to hold a single sms message.
class NewSmsArray : ArrayList<SmsMessage>(), BroadcastObj
