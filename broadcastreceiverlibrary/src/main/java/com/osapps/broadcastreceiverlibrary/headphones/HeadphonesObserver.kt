package com.osapps.broadcastreceiverlibrary.headphones


import com.osapps.broadcastreceiverlibrary.generic.BroadcastObserver
import com.osapps.broadcastreceiverlibrary.headphones.HeadphonesObj

/**
 * Created by osapps on 07/05/2018.
 */
interface HeadphonesObserver : BroadcastObserver {
    fun onHeadphonesToggle(networkStateObj: HeadphonesObj)
}
