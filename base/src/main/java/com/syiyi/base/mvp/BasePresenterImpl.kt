package com.syiyi.base.mvp

import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.ListCompositeDisposable


/**
 *
 * Created by songlintao on 2017/12/19.
 */
abstract class BasePresenterImpl<T : IView>(protected var view: T) : IPresenter {
    private var listCompositeDisposable: ListCompositeDisposable = ListCompositeDisposable()

    protected fun auto(disposable: Disposable) {
        this.listCompositeDisposable.add(disposable)
    }

    override fun onResume() {

    }

    override fun onDetach() {
        this.listCompositeDisposable.clear()
    }
}
