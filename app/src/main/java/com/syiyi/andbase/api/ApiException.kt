package com.syiyi.andbase.api

/**
 * 出错的情况
 * Created by songlintao on 2017/12/20.
 */
class ApiException(code :Int,message: String?) : Throwable(message)