package com.vxg.mrrtest.app

import android.app.Application

/**
 * Created by vxg on 2017-10-17-0017.
 */

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //init
    }
}
