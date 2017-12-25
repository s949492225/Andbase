package com.syiyi.andbase

import com.syiyi.andbase.bean.HomeBean
import com.syiyi.base.mvp.IView

/**
 *
 * Created by songlintao on 2017/12/25.
 */
interface IMainView : IView<MainPresenter> {
    fun showData(data: HomeBean)
}