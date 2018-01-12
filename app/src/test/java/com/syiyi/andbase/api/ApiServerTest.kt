package com.syiyi.andbase.api

import com.syiyi.base.net.ApiException
import com.syiyi.base.net.ErrorConsumer
import io.reactivex.functions.Consumer
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * 接口测试
 * Created by songlintao on 2017/12/25.
 */
@RunWith(RobolectricTestRunner::class)
class ApiServerTest {
    @Test
    fun getHomeData() {
        api().getHomeTabs()
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