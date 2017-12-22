package com.syiyi.base.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 *
 * Created by songlintao on 2017/12/19.
 */
abstract class BasePresenterImp<T:IView<*>>(protected var view:T) : IPresenter {
    private var mCompositeDisposable: CompositeDisposable? = null

    protected fun auto(s: Disposable) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = CompositeDisposable()
        }
        this.mCompositeDisposable!!.add(s)
    }

    override fun onResume() {

    }

    override fun onDetach() {
        this.mCompositeDisposable!!.dispose()
    }
}
