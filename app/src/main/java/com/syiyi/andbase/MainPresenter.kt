package com.syiyi.andbase

import android.util.Log
import com.hazz.kotlinmvp.net.RetrofitManager
import com.syiyi.andbase.api.ApiException
import com.syiyi.andbase.api.Helper
import com.syiyi.andbase.bean.DataClass
import com.syiyi.andbase.net.ErrorConsumer
import com.syiyi.base.mvp.BasePresenterImp
import io.reactivex.functions.Consumer

/**
 *
 * Created by songlintao on 2017/12/21.
 */
class MainPresenter(view: MainActivity): BasePresenterImp<MainActivity>(view) {

    override fun onAttach() {

    }

    fun getData() {
        auto(
                RetrofitManager.service.getFirstHomeData()
                        .compose(Helper.io2main())
                        .map(Helper.HttpResultFunc())
                        .subscribe(
                                Consumer<ArrayList<DataClass>> { t -> Log.d("xxx", t.toString()); }
                                ,
                                object : ErrorConsumer() {
                                    override fun onError(e: ApiException) {
                                        Log.d("xx2", e.toString())
                                    }

                                }
                        )
        )
    }
}