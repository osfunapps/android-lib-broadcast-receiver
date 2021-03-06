package com.osapps.broadcastreceiverlibrary.network


import com.osapps.broadcastreceiverlibrary.generic.BroadcastObserver
import com.osapps.broadcastreceiverlibrary.headphones.HeadphonesObj

/**
 * Created by osapps on 07/05/2018.
 */
interface NetworkObserver : BroadcastObserver {
    fun onNetworkChanged(networkStateObj: NewNetworkStateObj)
}
