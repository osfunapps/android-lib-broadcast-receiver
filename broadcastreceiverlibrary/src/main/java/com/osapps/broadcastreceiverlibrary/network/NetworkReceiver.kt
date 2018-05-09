package com.osapps.broadcastreceiverlibrary.network

import android.content.Intent
import android.net.NetworkInfo

import com.osapps.broadcastreceiverlibrary.generic.BroadcastReceiver


/**
 * Created by osapps on 07/05/2018.
 */

/**
 * This receiver meant to catch all of the network changes, like connected/disconnected and more.
 *
 * The return object will be a state, from [NetworkInfo.State] so use it to understand the state.
 *
 * To use, just inject the receiver and subscribe the observers to it.
 * And by god don't forget to add the network permissions in your app's manifest file.
 */
class NetworkReceiver : BroadcastReceiver<NetworkObserver, NewNetworkStateObj>() {

    override val intentFilterName: String
        get() = "android.net.conn.CONNECTIVITY_CHANGE"


    override fun notifyObserver(observer: NetworkObserver, broadcastObj: NewNetworkStateObj) {
        observer.onNetworkChanged(broadcastObj)
    }

    override fun extractIntent(intent: Intent): NewNetworkStateObj {
        val extras = intent.extras!!
        val info = extras.getParcelable<NetworkInfo>("networkInfo")!!
        return NewNetworkStateObj(info.state)
    }

}
