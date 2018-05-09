package com.osapps.broadcastreceiverlibrary.network

import android.net.NetworkInfo

import com.osapps.broadcastreceiverlibrary.generic.BroadcastObj


/**
 * Created by osapps on 08/05/2018.
 */
class NewNetworkStateObj(//do not change this. For flexibility purposes, we will stay with the whole java generated object
        //and save it as a whole. We don't want to wipe the methods out of it and decrease functionality.
        /** an enum. See types here: [NetworkInfo.State]  */
        val state: NetworkInfo.State) : BroadcastObj
