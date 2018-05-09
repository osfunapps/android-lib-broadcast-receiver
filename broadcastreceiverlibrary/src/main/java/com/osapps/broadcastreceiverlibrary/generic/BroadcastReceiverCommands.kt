package com.osapps.broadcastreceiverlibrary.generic

import android.app.Activity

/**
 * Created by osapps on 09/05/2018.
 */
internal interface BroadcastReceiverCommands {

    fun create()
    fun remove(activity: Activity)
    fun register(activity: Activity)
    fun unregister(activity: Activity)

}
