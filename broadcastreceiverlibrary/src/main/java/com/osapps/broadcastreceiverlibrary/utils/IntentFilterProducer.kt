package com.osapps.broadcastreceiverlibrary.utils

import android.content.IntentFilter

import java.util.Random

/**
 * Created by osapps on 09/05/2018.
 */
fun produceFilter(filterName: String): IntentFilter {
        val intentFilter = IntentFilter()
        intentFilter.addAction(filterName)
        intentFilter.priority = Random().nextInt(100)
        return intentFilter
    }
