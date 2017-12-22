package com.syiyi.base.mvp

/**
 * 基类
 * Created by songlintao on 2017/12/19.
 */
interface IPresenter {
    fun onAttach()
    fun onDetach()
    fun onResume()
}