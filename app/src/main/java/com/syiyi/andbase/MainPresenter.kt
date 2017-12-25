package com.syiyi.andbase

import com.syiyi.andbase.api.ApiException
import com.syiyi.andbase.api.Helper
import com.syiyi.andbase.bean.HomeBean
import com.syiyi.andbase.net.ErrorConsumer
import com.syiyi.andbase.net.RetrofitManager
import com.syiyi.base.mvp.BasePresenterImp
import io.reactivex.functions.Consumer

/**
 *
 * Created by songlintao on 2017/12/21.
 */
class MainPresenter(view: IMainView) : BasePresenterImp<IMainView>(view) {
    override fun onAttach() {
        getData()
    }

    fun getData() {
        auto(
                RetrofitManager.service.getFirstHomeData(1)
                        .compose(Helper.io2main())
                        .subscribe(
                                Consumer { t ->
                                    loadData(t)
                                },
                                object : ErrorConsumer() {
                                    override fun onError(e: ApiException) {
                                        println(e)
                                    }

                                }
                        )
        )
    }

    private fun loadData(data: HomeBean) {
        view.showData(data)
    }


}