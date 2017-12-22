package com.syiyi.andbase.net

import com.syiyi.andbase.api.ApiException
import io.reactivex.functions.Consumer

/**
 *
 * Created by songlintao on 2017/12/21.
 */
abstract class ErrorConsumer : Consumer<Throwable> {
    override fun accept(e: Throwable) {
        onError(ExceptionEngine.handleException(e))
    }

    abstract fun onError(e: ApiException)
}

