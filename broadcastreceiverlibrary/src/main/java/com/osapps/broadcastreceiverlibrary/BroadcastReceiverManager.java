package com.osapps.broadcastreceiverlibrary;

/**
 * Created by osapps on 07/05/2018.
 */

//todo: make singleton
public class BroadcastReceiverManager {

    /*private BroadcastReceiverManager(){}

    public static BroadcastReceiverManager instance;

    public static BroadcastReceiverManager getInstance(){
        if(instance == null) instance = new BroadcastReceiverManager();
        return instance;
    }



    //broadcast receivers list which are instantiated in the current session
    private Map<String, BroadcastReceiver> receiversMap = new HashMap<>();

    //add broadcast receiver
    public <T extends BroadcastReceiver> void addBroadcastReceiver(Class<T> receiver) {
        if(receiverExists(receiver)) return;
        receiversMap.put(receiver.getSimpleName(), getNewInstance(receiver));
    }

    //remove broadcast receiver
    //notice: you gotta unregister the receiver BEFORE removing it from the list!
    public <T extends BroadcastReceiver> void removeBroadcastReceiver(Class<T> receiver) {
        if(!receiverExists(receiver)) return;
        receiversMap.remove(receiver.getSimpleName());

    }

    //register receiver (on activity create/resume)
    public <T extends BroadcastReceiver> void registerBroadcastReceiver(Activity activity, Class<T> receiver) {
        if(!receiverExists(receiver)) return;
        receiversMap.get(receiver.getSimpleName()).register(activity);
    }

    //unregister receiver (on activity pause/stop)
    public <T extends BroadcastReceiver> void unregisterReceiver(Activity activity, Class<T> receiver) {
        if(!receiverExists(receiver)) return;

        receiversMap.get(receiver.getSimpleName()).unregister(activity);
    }


    @SuppressWarnings("unchecked")
    public <T extends BroadcastReceiver> T getBroadcastReceiver(Class<T> receiver){
        if(!receiverExists(receiver))return null;
        return (T) receiversMap.get(receiver.getSimpleName());
    }


    private <T extends BroadcastReceiver> BroadcastReceiver getNewInstance(Class<T> receiver) {
        try {
            return receiver.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void registerAllReceivers(Activity activity){
        for(BroadcastReceiver receiver : receiversMap.values()){
            receiver.register(activity);
        }
    }

    public void unregisterAllReceivers(Activity activity){
        for(BroadcastReceiver receiver : receiversMap.values()){
            receiver.unregister(activity);
        }
    }



    private <T extends BroadcastReceiver> boolean receiverExists(Class<T> receiver) {
        return receiversMap.containsKey(receiver.getSimpleName());
    }
*/
}

