package com.osapps.broadcastreceiverlibrary.generic;

/**
 * Created by osapps on 07/05/2018.
 */

/** Notice: we will create an observer for each state (NetworkChange, SMS etc) cause we would want
 * to handle two observer implementation at the same class and we don't want them to have the same
 * name cause it will make conflicts for the client.
 */
public interface BroadcastObserver {

}
