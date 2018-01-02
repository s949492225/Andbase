package com.syiyi.andbase.app

import com.syiyi.andbase.bean.HomeBean
import com.syiyi.base.mvp.IPresenter
import com.syiyi.base.mvp.IView

/**
 *
 * Created by songlintao on 2018/1/2.
 */
class MainContract {
    interface Presenter :IPresenter{
        fun getData()
    }

    interface View : IView {
        fun showData(data: HomeBean)
    }
}