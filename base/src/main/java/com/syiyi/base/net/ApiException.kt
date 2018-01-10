package com.syiyi.base.net

/**
 * 出错的情况
 * Created by songlintao on 2017/12/20.
 */
class ApiException(val code :Int,message: String) : Throwable(message)