# An easy Broadcast Receiver library for Android.

## Introduction

This library meant to handle all of the Broadcast Receiver operations using the Observer design pattern, to keep updating all of the broadcast listeners. 

For example, using this library you can keep track of the network status, no matter where are you in your App. just inject the NetworkReceiver object to your instance and you good to go!

This library works on Google's Dagger 2.1 android design, the recommended app architecture by Google.

## Installing

### Gradle:

add the gradle dependency:

```compile 'com.github.osfunapps:weedle-android-core-library:v1.0.2' ```


## Usage

1) add the library module **BroadcastReceiverLibraryBuilder::class** to your app component.

    Example:
    ```
    @Singleton
    @Component(modules = [
        AndroidSupportInjectionModule::class,
       AppModule::class,
      ActivityBuilder::class,
      BroadcastReceiverLibraryBuilder::class])
    ```
    
    
2) add the desired broadcast receiver to your instance:

  We will add the network receiver to the MainPresenter.kt, for example:
  ```
  @Module
  class MainActivityModule {

    //the main activity view
    @Provides
    fun provideMainView(mainActivity: MainActivity) : MainActivityView = mainActivity

    //the main presenter
    @Provides
    @PerActivity
    fun provideMainPresenter(mainActivityView: MainActivityView, networkReceiver: NetworkReceiver): MainActivityPresenterImpl {
        return MainActivityPresenterImpl(mainActivityView, networkReceiver)
    }

}
   ```
   
   
3) inject the receiver to your presenter:

```
class MainActivityPresenterImpl @Inject constructor(private var view: MainActivityView,
                                                    private var networkReceiver: NetworkReceiver) : NetworkObserver {
```


4) subscribe your instance to get calls:
```
 fun viewReady() {
        //view.onPresenterReady()
        networkReceiver.create()
        networkReceiver.register(view.getActivity())
        networkReceiver.subscribeObserver(this)
    }


    override fun onNetworkChanged(networkStateObj: NewNetworkStateObj) {
        println(networkStateObj.state.name)
    }

 ```
And that's it. 

Don't forget to register and unregister your receiver in the activity onResume/onStop.

## Develop

---
Any contributions for this repository is blessed, just make sure to:
* Design in DI style with Dagger 2.1
* Write your code in Kotlin
* Seperate views from controllers and modules
* Stick to generics
* Work with the Observer design pattern
* Do not use reflections
