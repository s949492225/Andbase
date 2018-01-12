package com.syiyi.base.net

import com.syiyi.base.util.getVersionCode
import okhttp3.*
import java.util.concurrent.TimeUnit

/**
 *
 * Created by songlintao on 2017/12/20.
 */
object OkHttpCreator {
    val client = createClient()
    private fun createClient(): OkHttpClient {
        return with(OkHttpClient.Builder(), {
            addInterceptor(addQueryParameterInterceptor())  //参数添加
            setCookie(this)
            addInterceptor(addHeaderInterceptor()) // header
            connectTimeout(60L, TimeUnit.SECONDS)
            readTimeout(60L, TimeUnit.SECONDS)
            writeTimeout(60L, TimeUnit.SECONDS)
            build()
        })
    }

    private fun setCookie(builder: OkHttpClient.Builder) {
        builder.cookieJar(object : CookieJar {
            override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
                CookieHelper.saveFromResponse(url.host(), cookies)
            }

            override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
                return CookieHelper.loadForRequest(url.host())
            }

        })
    }

    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                    .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }

    /**
     * 设置头
     */
    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                    .method(originalRequest.method(), originalRequest.body())
                    .addHeader("CLIENT_TYPE", "Android")
                    .addHeader("CLIENT_VERSION", getVersionCode().toString())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

}