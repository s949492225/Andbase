package com.syiyi.base.thread

import android.os.Handler
import android.os.Looper
import com.syiyi.base.util.CommonPool

/**
 * 线程切换类
 * Created by songlintao on 2018/1/12.
 */
class MultiScheduler
{
    @Volatile var fstop  = false
    val handler: Handler = Handler(Looper.getMainLooper())

    inline fun work(crossinline block: () -> Unit) {
        if (fstop)
            return

        CommonPool.submit({
            if (!fstop) {
                block()
            }
        })
    }

    inline fun ui(crossinline block: () -> Unit) {
        if (fstop)
            return
        handler.post {
            if (!fstop) {
                block()
            }
        }
    }

    fun stop() {
        fstop = true
        handler.removeCallbacksAndMessages(null)
    }
}