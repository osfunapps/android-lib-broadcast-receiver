package com.osapps.broadcastreceiverlibrary.network;

import android.net.NetworkInfo;

import com.osapps.broadcastreceiverlibrary.generic.BroadcastObj;


/**
 * Created by osapps on 08/05/2018.
 */
public class NewNetworkStateObj implements BroadcastObj {


    //do not change this. For flexibility purposes, we will stay with the whole java generated object
    //and save it as a whole. We don't want to wipe the methods out of it and decrease functionality.
    private final NetworkInfo.State state;


    public NewNetworkStateObj(NetworkInfo.State state){
        this.state = state;
    }

    /** an enum. See types here: {@link NetworkInfo.State} */
    public NetworkInfo.State getState() {
        return state;
    }
}
