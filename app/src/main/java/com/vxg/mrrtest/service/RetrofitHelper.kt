package com.vxg.mrrtest.service

import android.annotation.SuppressLint
import android.content.Context

import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vxg on 2017-10-17-0017.
 */

class RetrofitHelper private constructor(private val mCntext: Context) {
    private val client = OkHttpClient()
    private val factory = GsonConverterFactory.create(GsonBuilder().create())
    private var mRetrofit: Retrofit? = null

    val server: RetrofitService
        get() = mRetrofit!!.create(RetrofitService::class.java)

    init {
        init()
    }

    private fun init() {
        resetApp()
    }

    private fun resetApp() {
        mRetrofit = Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        var instance: RetrofitHelper? = null

        fun getInstance(c: Context): RetrofitHelper {
            if (instance == null) {
                synchronized(RetrofitHelper::class) {
                    if (instance == null) {
                        instance = RetrofitHelper(c)
                    }
                }
            }
            return instance!!
        }
    }
}
