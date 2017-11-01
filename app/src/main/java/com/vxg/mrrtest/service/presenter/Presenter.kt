package com.vxg.mrrtest.service.presenter

import android.content.Intent
import com.vxg.mrrtest.service.view.IView

/**
 * Created by vxg on 2017-10-17-0017.
 */
interface Presenter {
    fun onCreate()
    fun onStart()
    fun onStop()
    fun pause()
    fun attachView(view : IView)
    fun attachIncomingIntent(intent : Intent)
}