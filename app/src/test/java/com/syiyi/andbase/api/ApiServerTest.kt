package com.syiyi.andbase.api

import com.syiyi.base.net.ApiException
import com.syiyi.base.net.ErrorConsumer
import com.syiyi.base.net.RetrofitManager
import io.reactivex.functions.Consumer
import org.junit.Test

/**
 * 接口测试
 * Created by songlintao on 2017/12/25.
 */
class ApiServerTest {
    @Test
    fun getHomeData() {
        api().getFirstHomeData(1)
                .subscribe(
                        Consumer { t ->
                            val data = t.toString()
                            println(data)
                        },
                        object : ErrorConsumer() {
                            override fun onError(e: ApiException) {
                                println(e)
                            }

                        }
                )

    }
}