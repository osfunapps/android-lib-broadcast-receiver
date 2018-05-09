package com.osapps.broadcastreceiverlibrary.generic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import com.osapps.broadcastreceiverlibrary.utils.IntentFilterProducer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osapps on 07/05/2018.
 */
public abstract class BroadcastReceiver<T extends BroadcastObserver, E extends BroadcastObj>
        extends android.content.BroadcastReceiver implements BroadcastReceiverCommands {


    //the map of current observers of this receiver. Should stay map cause we will identify them by name.
    protected Map<String, T> observersMap;

    @Override
    public void create() {
        if(observersMap != null) return;
        observersMap = new HashMap<>();
    }


    @Override
    public void remove(Activity activity) {

        //unsubscribe from all of the observers and nullify the list
        for (T observer : observersMap.values())
            unsubscribeObserver(observer);
        clearAllObservers();
        observersMap = null;

        //unregister this receiver
        if(isRegistered) unregister(activity);

    }


    //register this receiver to activity
    public void register(Activity activity) {
        isRegistered = true;
        activity.registerReceiver(this, IntentFilterProducer.produceFilter(getIntentFilterName()));
    }

    //unregister this receiver to activity
    public void unregister(Activity activity) {
        isRegistered = false;
        activity.unregisterReceiver(this);
    }



    private Boolean isRegistered = false;


    public void subscribeObserver(T observer) {
        if (observerExists(observer) || isRegistered) return;
        observersMap.put(observer.getClass().getSimpleName(), observer);
    }


    //remove observer
    public void unsubscribeObserver(T observer) {
        if (!observerExists(observer) || !isRegistered) return;
        observersMap.remove(observer.getClass().getSimpleName());
    }


    //null check for observer
    private boolean observerExists(T observer) {
        return observersMap.containsKey(observer.getClass().getSimpleName());
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        E broadcastObj = extractIntent(intent);
        notifyObservers(broadcastObj);
    }


    private void notifyObservers(E broadcastObj) {
        for (T observer : observersMap.values())
            notifyObserver(observer, broadcastObj);
    }

    public void clearAllObservers() {
        observersMap.clear();
    }



    protected abstract void notifyObserver(T observer, E object);

    protected abstract E extractIntent(Intent intent);

    protected abstract String getIntentFilterName();
}
