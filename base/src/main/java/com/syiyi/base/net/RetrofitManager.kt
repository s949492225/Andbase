package com.syiyi.base.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xuhao on 2017/11/16.
 *
 */

object RetrofitManager {

    private var retrofit: Retrofit? = null

    private fun getRetrofit(url: String): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitManager::class.java) {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                            .baseUrl(url)
                            .client(OkHttpCreator.client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
            }
        }
        return retrofit
    }

    fun <T> create(url: String, clazz: Class<T>): T {
        return getRetrofit(url)!!.create(clazz)
    }

}
