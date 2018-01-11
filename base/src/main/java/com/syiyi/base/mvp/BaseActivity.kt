package com.syiyi.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.syiyi.base.other.back.BackHandlerHelper
import com.syiyi.base.util.hideSoftInput

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
        getPresenter()?.onAttach()
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
        getPresenter()?.onResume()
    }

    override fun onPause() {
        super.onPause()
        hideSoftInput(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter()?.onDetach()
    }

    override fun onBackPressed() {
        if (!BackHandlerHelper.handleBackPress(this)) {
            super.onBackPressed()
        }
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