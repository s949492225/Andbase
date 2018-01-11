package com.syiyi.andbase.app.main

import android.widget.Toast
import com.syiyi.andbase.api.api
import com.syiyi.base.net.ApiException
import com.syiyi.base.net.Helper
import com.syiyi.andbase.bean.HomeBean
import com.syiyi.base.net.ErrorConsumer
import com.syiyi.base.mvp.BasePresenterImpl
import io.reactivex.functions.Consumer

/**
 *
 * Created by songlintao on 2017/12/21.
 */
class MainPresenter constructor(view: MainContract.View) : BasePresenterImpl<MainContract.View>(view), MainContract.Presenter {
    override fun onAttach() {
        getData()
    }

    override fun getData() {
        auto(
                api().getFirstHomeData(1)
                        .compose(Helper.io2main())
                        .subscribe(
                                Consumer { t ->
                                    loadData(t)
                                },
                                object : ErrorConsumer() {
                                    override fun onError(e: ApiException) {
                                        view.showError(e.code, e.message!!)
                                    }

                                }
                        )
        )
//        auto(
//                api().getBaidu("https://www.baidu.com/s?wd=%E4%BB%8A%E6%97%A5%E6%96%B0%E9%B2%9C%E4%BA%8B&tn=SE_Pclogo_6ysd4c7a&sa=ire_dl_gh_logo&rsv_dl=igh_logo_pc")
//                        .compose(Helper.io2main())
//                        .subscribe({
//                            view.showData2(it)
//                        })
//        )
    }

    private fun loadData(data: HomeBean) {
        view.showData(data)
    }


}