package com.syiyi.andbase.api

import com.syiyi.andbase.Configs
import com.syiyi.base.net.RetrofitManager

/**
 * 网络请求
 * Created by songlintao on 2018/1/10.
 */

fun api(): ApiService {
    return RetrofitManager.create(Configs.BASE_URL, ApiService::class.java)
}
