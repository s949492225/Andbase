package com.syiyi.andbase

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 *
 * Created by songlintao on 2017/12/20.
 */
class App : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}