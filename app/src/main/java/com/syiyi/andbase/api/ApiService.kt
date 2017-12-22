package com.syiyi.andbase.api

import com.syiyi.andbase.bean.DataClass
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by songlintao on 2017/11/16.
 * Api 接口
 */

interface ApiService{

    /**
     * 首页精选
     */
    @GET("goods/goodList")

    fun getFirstHomeData(): Observable<HttpResult<ArrayList<DataClass>>>
}