package com.narinc.challenge

import android.app.Application
import com.narinc.challenge.core.initializer.InitializerDispatcher
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication : Application() {

    @Inject
    lateinit var initializerDispatcher: InitializerDispatcher

    override fun onCreate() {
        super.onCreate()
        initializerDispatcher.init(this)
    }
}
