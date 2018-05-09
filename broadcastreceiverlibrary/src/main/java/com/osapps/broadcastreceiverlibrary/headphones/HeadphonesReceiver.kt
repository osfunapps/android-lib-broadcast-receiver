package com.osapps.broadcastreceiverlibrary.headphones

import android.content.Intent
import android.net.NetworkInfo

import com.osapps.broadcastreceiverlibrary.generic.BroadcastReceiver


/**
 * Created by osapps on 07/05/2018.
 */

/**
 * This receiver meant to catch all of the headphones changes, like connected/disconnected.
 *
 * The return object will be a state carrying the state (connected or not)
 *
 * To use, just inject the receiver and subscribe the observers to it.
 * You don't need any android special permissions.
 */
class HeadphonesReceiver : BroadcastReceiver<HeadphonesObserver, HeadphonesObj>() {
    override fun notifyObserver(observer: HeadphonesObserver, broadcastObj: HeadphonesObj) {
        observer.onHeadphonesToggle(broadcastObj)
    }

    override val intentFilterName: String
        get() = Intent.ACTION_HEADSET_PLUG


    override fun extractIntent(intent: Intent): HeadphonesObj {
        val state = intent.getIntExtra("state", -1)
        return HeadphonesObj(state == 1)
    }

}
