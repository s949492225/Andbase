package com.syiyi.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syiyi.base.other.back.BackHandledInterface
import com.syiyi.base.other.back.BackHandlerHelper

/**
 *
 * Created by songlintao on 2017/12/20.
 */
abstract class BaseFragment : Fragment(), IView, BackHandledInterface {

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    /**
     * 数据是否加载过了
     */
    private var hasLoadData = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retainInstance = true
        return inflater.inflate(getLayoutId(), null)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView()
        lazyLoadDataIfPrepared()
    }

    protected fun lazyLoadDataIfPrepared() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
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

    override fun onResume() {
        super.onResume()
        getPresenter()?.onResume()
    }

    override fun onDetach() {
        super.onDetach()
        getPresenter()?.onDetach()
    }

    override fun onBackPressed(): Boolean {
        return BackHandlerHelper.handleBackPress(this)
    }

    /**
     * 懒加载
     */
    protected fun lazyLoad() {
        inject()
        getPresenter()?.onAttach()
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun showError(code: Int, message: String) {
    }

    abstract fun inject()


}