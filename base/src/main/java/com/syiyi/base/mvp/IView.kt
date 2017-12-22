package com.syiyi.base.mvp

/**
 * view基类
 * Created by songlintao on 2017/12/19.
 */
interface IView<out T:IPresenter> {
    fun createPresenter(): T
    fun showLoading()
    fun dismissLoading()
    fun showError(code: Int)
}