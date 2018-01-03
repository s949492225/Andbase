package com.syiyi.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * 基类
 * Created by songlintao on 2017/12/19.
 */
abstract class BaseActivity : AppCompatActivity(), IView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        inject()
        initView()
        getPresenter().onAttach()
    }

    /**
     * 加载布局
     */
    @LayoutRes protected
    abstract fun getLayoutId(): Int

    /**
     * 初始化 ViewI
     */
    abstract fun initView()

    override fun onResume() {
        super.onResume()
        getPresenter().onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().onDetach()
    }

    /**
     * optional
     */
    override fun showLoading() {

    }

    /**
     * optional
     */
    override fun dismissLoading() {

    }

    /**
     * optional
     */
    override fun showError(code: Int, message: String) {

    }

    abstract fun inject()
}