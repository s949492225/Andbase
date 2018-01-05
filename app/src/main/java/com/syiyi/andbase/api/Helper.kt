package com.syiyi.andbase.api

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

@Suppress("unused")
/**
 *
 * Created by songlintao on 2017/12/20.
 */
object Helper {
    fun <T> io2main(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * 数据格式处理的函数
     * Created by songlintao on 2017/12/20.
     */

    class HttpResultFunc<T> : Function<HttpResult<T>, T> {
        override fun apply(t: HttpResult<T>): T? {
            if (t.code != 200) {
                throw ApiException(t.code, t.message)
            }
            return t.datas
        }

    }
}