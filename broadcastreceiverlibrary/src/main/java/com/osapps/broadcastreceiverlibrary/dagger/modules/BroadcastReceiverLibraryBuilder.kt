package com.osapps.broadcastreceiverlibrary.dagger.modules

import com.osapps.broadcastreceiverlibrary.headphones.HeadphonesReceiver
import com.osapps.broadcastreceiverlibrary.network.NetworkReceiver
import com.osapps.broadcastreceiverlibrary.sms.SmsReceiver
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

    @Provides
    @Singleton
    fun provideSmsReceiver(): SmsReceiver {
        return SmsReceiver()
    }

    @Provides
    @Singleton
    fun provideHeadphonesReceiver(): HeadphonesReceiver {
        return HeadphonesReceiver()
    }


}