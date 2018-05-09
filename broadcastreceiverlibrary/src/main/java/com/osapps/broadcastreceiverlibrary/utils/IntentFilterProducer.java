package com.osapps.broadcastreceiverlibrary.utils;

import android.content.IntentFilter;

import java.util.Random;

/**
 * Created by osapps on 09/05/2018.
 */
public class IntentFilterProducer {


    public static IntentFilter produceFilter(String filterName) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(filterName);
        intentFilter.setPriority(new Random().nextInt(100));
        return intentFilter;
    }
}
