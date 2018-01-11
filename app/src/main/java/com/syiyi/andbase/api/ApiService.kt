package com.syiyi.andbase.api

import com.syiyi.andbase.bean.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by songlintao on 2017/11/16.
 * Api 接口
 */

interface ApiService {

    /**
     * 首页精选
     */
    @GET("v2/feed?")
    fun getFirstHomeData(@Query("num") num: Int): Observable<HomeBean>

    /**
     * 首页精选
     */
    @GET
    fun getBaidu(@Url url: String): Observable<String>
}