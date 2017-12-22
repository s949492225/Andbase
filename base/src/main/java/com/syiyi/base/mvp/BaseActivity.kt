package com.syiyi.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * 基类
 * Created by songlintao on 2017/12/19.
 */
abstract class BaseActivity<T : IPresenter> : AppCompatActivity(), IView<T> {
    protected lateinit var presenter: T
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        presenter = createPresenter()
        presenter.onAttach()
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
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
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
    override fun showError(code: Int) {

    }
}