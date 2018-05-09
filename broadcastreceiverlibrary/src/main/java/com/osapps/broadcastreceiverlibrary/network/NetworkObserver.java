package com.osapps.broadcastreceiverlibrary.network;


import com.osapps.broadcastreceiverlibrary.generic.BroadcastObserver;

/**
 * Created by osapps on 07/05/2018.
 */
public interface
NetworkObserver extends BroadcastObserver {
    void onNetworkChanged(NewNetworkStateObj networkStateObj);
    void registerReceivers(boolean register);
}
