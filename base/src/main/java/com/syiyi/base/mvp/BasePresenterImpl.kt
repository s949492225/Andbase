package com.syiyi.base.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 *
 * Created by songlintao on 2017/12/19.
 */
abstract class BasePresenterImp<T : IView<*>>(protected var view: T) : IPresenter {
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun auto(disposable: Disposable) {
        this.mCompositeDisposable.add(disposable)
    }

    override fun onResume() {

    }

    override fun onDetach() {
        this.mCompositeDisposable.clear()
    }
}
