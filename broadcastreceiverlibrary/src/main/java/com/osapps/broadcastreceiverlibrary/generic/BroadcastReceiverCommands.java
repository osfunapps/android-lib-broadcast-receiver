package com.osapps.broadcastreceiverlibrary.generic;

import android.app.Activity;

/**
 * Created by osapps on 09/05/2018.
 */
interface BroadcastReceiverCommands<T extends BroadcastObserver> {

    public void create();
    public void remove(Activity activity);
    public void register(Activity activity);
    public void unregister(Activity activity);

}
