package com.narinc.rootproject.core.initializer

import android.content.Context

class InitializerDispatcherImp : InitializerDispatcher {

    private val dispatchers: List<InitializerDispatcher> by lazy {
        buildList {
            // add diaspathers
        }
    }

    override fun init(context: Context) {
        for (dispatcher in dispatchers) {
            dispatcher.init(context)
        }
    }
}
