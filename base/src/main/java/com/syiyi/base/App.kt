package com.syiyi.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 *
 * Created by songlintao on 2017/12/20.
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        ContextHolder.context = applicationContext
    }
}

@SuppressLint("StaticFieldLeak")
object ContextHolder {
    lateinit var context: Context
}