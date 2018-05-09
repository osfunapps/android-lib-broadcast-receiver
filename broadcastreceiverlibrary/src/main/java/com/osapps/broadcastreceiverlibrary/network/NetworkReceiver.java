package com.osapps.broadcastreceiverlibrary.network;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.osapps.broadcastreceiverlibrary.generic.BroadcastReceiver;


/**
 * Created by osapps on 07/05/2018.
 */
public class NetworkReceiver extends BroadcastReceiver<NetworkObserver, NewNetworkStateObj> {


    @Override
    protected void notifyObserver(@NonNull NetworkObserver observer, @NonNull NewNetworkStateObj object) {
        observer.onNetworkChanged(object);
    }

    @NonNull
    @Override
    protected NewNetworkStateObj extractIntent(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        assert extras != null;
        NetworkInfo info = extras.getParcelable("networkInfo");
        assert info != null;
        return new NewNetworkStateObj(info.getState());
    }

    @NonNull
    @Override
    protected String getIntentFilterName() {
        return "android.net.conn.CONNECTIVITY_CHANGE";
    }

}
