package com.osapps.broadcastreceiverlibrary.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import com.osapps.broadcastreceiverlibrary.network.NetworkReceiver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by osapps on 05/05/2018.
 */

@Module
class BroadcastReceiverLibraryBuilder {

    //provide broadcast receivers

    @Provides
    @Singleton
    fun provideNetworkReceiver(): NetworkReceiver {
        return NetworkReceiver()
    }
}