package com.syiyi.andbase.net

import android.net.ParseException

import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import com.syiyi.andbase.api.ApiException

import org.json.JSONException

import java.net.ConnectException
import java.net.SocketTimeoutException

import retrofit2.HttpException

@Suppress("MemberVisibilityCanPrivate")
/**
 * 异常统一处理
 * Created by songlintao on 2017/12/21.
 */

object ExceptionEngine {

    const val API_UN_KNOWN_ERROR = 1000//未知错误
    const val API_SERVER_DATA_ERROR = 1001//解析(服务器)数据错误
    const val API_CONNECT_ERROR = 1003//网络连接错误
    const val API_TIME_OUT_ERROR = 1004//网络连接超时

    fun handleException(e: Throwable): ApiException {
        val ex: ApiException
        if (e is HttpException) {             //HTTP错误
            ex = ApiException(e.code(), e.message())
            return ex
        } else if (e is ApiException) {    //服务器返回的错误
            ex = e
            return ex
        } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException || e is MalformedJsonException) {  //解析数据错误
            ex = ApiException(API_SERVER_DATA_ERROR, "解析错误")
            return ex
        } else if (e is ConnectException) {//连接网络错误
            ex = ApiException(API_CONNECT_ERROR, "连接失败")
            return ex
        } else if (e is SocketTimeoutException) {//网络超时
            ex = ApiException(API_TIME_OUT_ERROR, "网络超时")
            return ex
        } else {  //未知错误
            ex = ApiException(API_UN_KNOWN_ERROR, "未知错误")
            return ex
        }
    }

}
