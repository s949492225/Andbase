package com.syiyi.andbase.net

import com.syiyi.andbase.api.ApiService
import com.syiyi.andbase.api.UriConstant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xuhao on 2017/11/16.
 *
 */

object RetrofitManager {

    private var retrofit: Retrofit? = null

    val service: ApiService by lazy { getRetrofit()!!.create(ApiService::class.java) }


    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitManager::class.java) {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                            .baseUrl(UriConstant.BASE_URL)
                            .client(OkHttpCreator.client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
            }
        }
        return retrofit
    }

    fun <T> create(clazz: Class<T>): T {
        return getRetrofit()!!.create(clazz)
    }

}
