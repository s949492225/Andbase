package com.syiyi.andbase.app.main.inject

import dagger.Provides
import com.syiyi.andbase.app.main.MainContract
import com.syiyi.andbase.app.main.MainPresenter
import dagger.Module

/**
 *
 * Created by songlintao on 2018/1/2.
 */
@Module
class MainModule constructor(val view: MainContract.View) {

    @Provides
    fun provideView() = view

    @Provides
    fun providePresenter(): MainContract.Presenter = MainPresenter(view)
}