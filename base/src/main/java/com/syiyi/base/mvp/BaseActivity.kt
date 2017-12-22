package com.syiyi.base.mvp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * 基类
 * Created by songlintao on 2017/12/19.
 */
abstract class BaseActivity<T:IPresenter> : AppCompatActivity(), IView<T> {
    var presenter: T? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayoutId())
        initView()
    }

    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 初始化 ViewI
     */
    abstract fun initView()

    override fun onStart() {
        super.onStart()
        if (presenter == null) {
            presenter = createPresenter()
            presenter!!.onAttach()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter!!.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDetach()
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