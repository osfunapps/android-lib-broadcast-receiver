package com.osapps.broadcastreceiverlibrary.generic

import android.app.Activity
import android.content.Context
import android.content.Intent


import com.osapps.broadcastreceiverlibrary.utils.IntentFilterProducer

import kotlin.collections.HashMap

/**
 * Created by osapps on 07/05/2018.
 */

/**
 * Broadcast Receiver Library
 *
 * <p>This library meant to handle all of the broadcast receiver operations for you.
 * It currently supports network change and sms receiving. You free to stretch it as you will.
 * This library runs on Dagger 2.1.
 * </p>
 *
 * To use:
 *
 * 1) add the library module [BroadcastReceiverLibraryBuilder] to your app component module
 * 2) inject any broadcast receiver you desire to any of your instances
 * 3) CREATE the receiver whenever you first implement it (broadcastReceiver.create())
 * 4) REGISTER the receiver to an activity instance
 * 5) SUBSCRIBE your instance to any changes in the receiver
 * 6) UNREGISTER the receiver whenever you'll stop using it
 *
 * IMPORTANT: this library is smart, but it wont handle the activity registration and un registration
 * for you. Do so in your activity's onResume and onStop lifecycle
 *
 * see [https://github.com/osfunapps/android-lib-broadcast-receiver] for further explanations.
 *
 * NOTE FOR DEVELOPERS:
 * to add receiver:
 * 1) create a receiver object (the object the receiver will return; like the [NewNetworkStateObj])
 * 2) create an observer (the whistle blower for any changes in the receiver; like the [network.NetworkObserver])
 * 3) create a receiver, and implement the necessary functions (the receiver..; like the [NetworkReceiver])
 *
 * NOTICE: for each of them you will need to implement functions, so just look how the network change
 * works and you will understand. It's pretty easy.
 *
 * Please follow the Dagger 2.10, generics and observer pattern
 * @author  osApps
 * @version 1.0
 * @since   05-09-18
 */
abstract class BroadcastReceiver<in T : BroadcastObserver, E : BroadcastObj> : android.content.BroadcastReceiver(), BroadcastReceiverCommands {


    //the map of current observers of this receiver. Should stay map cause we will identify them by name.
    private var observersMap: MutableMap<String, T>? = null

    //a toggle if the receiver is registered in the system or not
    //private var isRegistered: Boolean = false

    //getter for the intent filter. It will change by the specific receiver
    protected abstract val intentFilterName: String

    override fun remove(activity: Activity) {
        //unsubscribe from all of the observers and nullify the list
        for (observer in observersMap!!.values)
            unsubscribeObserver(observer)
        clearAllObservers()
        observersMap = null
        //unregister this receiver
        //if (isRegistered)
            unregister(activity)

    }


    //register this receiver to activity
    override fun register(activity: Activity) {
        //isRegistered = true
        if(observersMap == null) observersMap = HashMap()
        activity.registerReceiver(this, IntentFilterProducer.produceFilter(intentFilterName))
    }

    //unregister this receiver to activity
    override fun unregister(activity: Activity) {
        //isRegistered = false
        activity.unregisterReceiver(this)
    }


    fun subscribeObserver(observer: T) {
        if (observerExists(observer)) return
        //if (observerExists(observer) || isRegistered) return
        observersMap!![observer.javaClass.simpleName] = observer
    }


    //remove observer
    fun unsubscribeObserver(observer: T) {
        if (!observerExists(observer)) return
        //if (!observerExists(observer) || !(isRegistered)) return
        observersMap!!.remove(observer.javaClass.simpleName)
    }


    //null check for observer
    private fun observerExists(observer: T): Boolean {
        return observersMap!!.containsKey(observer.javaClass.simpleName)
    }


    override fun onReceive(context: Context, intent: Intent) {
        val broadcastObj = extractIntent(intent)
        notifyObservers(broadcastObj)
    }


    private fun notifyObservers(broadcastObj: E) {
        for (observer in observersMap!!.values)
            notifyObserver(observer, broadcastObj)
    }

    fun clearAllObservers() {
        observersMap!!.clear()
    }


    protected abstract fun notifyObserver(observer: T, broadcastObj: E)

    protected abstract fun extractIntent(intent: Intent): E
}
