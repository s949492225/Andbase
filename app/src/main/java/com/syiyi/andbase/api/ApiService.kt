package com.syiyi.andbase.api

import com.syiyi.andbase.bean.HomeBean
import com.syiyi.andbase.bean.HomeTab
import com.syiyi.base.net.HttpResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

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
    @GET("/mobile/index.php?act=index&op=tabs&client_type=ajax")
    fun getHomeTabs(): Observable<HttpResult<HomeTab>>
}