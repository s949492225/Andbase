package com.syiyi.andbase.app.main.inject

import com.syiyi.andbase.app.main.MainActivity
import dagger.Component


/**
 *
 * Created by songlintao on 2018/1/2.
 */
@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}