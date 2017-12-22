package com.syiyi.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *
 * Created by songlintao on 2017/12/20.
 */
abstract class BaseFragment<out T:IPresenter> : Fragment(), IView<T> {
    var presenter: IPresenter? = null

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    /**
     * 数据是否加载过了
     */
    private var hasLoadData = false


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retainInstance = true
        return inflater?.inflate(getLayoutId(), null)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView()
        lazyLoadDataIfPrepared()
    }

    private fun lazyLoadDataIfPrepared() {
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
        presenter!!.onResume()
    }

    override fun onDetach() {
        super.onDetach()
        presenter!!.onDetach()
    }

    /**
     * 懒加载
     */
    fun lazyLoad() {
        if (presenter == null) {
            presenter = createPresenter()
            presenter!!.onAttach()
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun showError(code: Int) {
    }


}