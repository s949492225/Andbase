package com.syiyi.andbase

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 *
 * Created by songlintao on 2017/12/20.
 */
class App : Application() {
    companion object {
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}