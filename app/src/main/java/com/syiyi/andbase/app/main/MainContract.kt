package com.syiyi.andbase.app.main

import com.syiyi.andbase.bean.HomeBean
import com.syiyi.andbase.bean.HomeTab
import com.syiyi.base.mvp.IPresenter
import com.syiyi.base.mvp.IView

/**
 *
 * Created by songlintao on 2018/1/2.
 */
class MainContract {
    interface Presenter : IPresenter {
        fun getData()
    }

    interface View : IView {
        fun showData(data: HomeBean)
        fun showData2(it: HomeTab)
    }
}