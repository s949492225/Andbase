package com.syiyi.andbase.api

import android.os.Handler
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * android环境下jvm测试
 * Created by songlintao on 2018/1/3.
 */
@RunWith(RobolectricTestRunner::class)
class JvmTest {
    @Test
    fun handlerTest() {
        val handler = Handler()
        handler.post {
            val a = 10
            assertEquals(a, 10)
        }
    }
}
