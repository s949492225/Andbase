package com.syiyi.base.net

/**
 * 数据统一返回格式
 * Created by songlintao on 2017/12/20.
 */
class HttpResult<T>(var code: Int, var message: String, var datas: T)