package com.syiyi.base.mvp

/**
 * view基类
 * Created by songlintao on 2017/12/19.
 */
interface IView {
    fun getPresenter(): IPresenter
    fun showLoading()
    fun dismissLoading()
    fun showError(code: Int, message: String)
}