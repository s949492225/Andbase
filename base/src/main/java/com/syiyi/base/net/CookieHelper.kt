@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.syiyi.base.net

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.syiyi.base.ContextHolder
import okhttp3.Cookie
import okhttp3.HttpUrl
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 *
 * Created by songlintao on 2018/1/11.
 */
object CookieHelper {
    private var cookiesMap: ConcurrentHashMap<String, MutableList<Cookie>> = ConcurrentHashMap()
    private var prefs: SharedPreferences = ContextHolder.context.getSharedPreferences("cookie", Context.MODE_PRIVATE)
    private val SPLIT = "$--$"

    init {
        loadFromLocal()
    }

    private fun loadFromLocal() {
        for (map in prefs.all) {
            val url = map.key
            val cookiesStr = map.value as String
            val list = mutableListOf<Cookie>()
            if (TextUtils.isEmpty(cookiesStr))
                return
            if (cookiesStr.contains(SPLIT)) {
                cookiesStr
                        .split(SPLIT)
                        .map({ Cookie.parse(parseHost(url), it)!! })
                        .filterNotTo(list) { it.hasExpired() }
            } else {
                if (!Cookie.parse(parseHost(url), cookiesStr)!!.hasExpired())
                    list.add(Cookie.parse(parseHost(url), cookiesStr)!!)
            }

            cookiesMap.put(map.key, list)
        }
    }


    fun saveFromResponse(url: String, cookies: MutableList<Cookie>) {
        if (cookies.size > 0) {
            val list = ArrayList<Cookie>()
            cookies.filterNotTo(list) { it.hasExpired() }
            cookiesMap.put(url, list)
            prefs.edit().putString(url, list.joinToString(SPLIT)).apply()
        }
    }

    fun loadForRequest(url: String): MutableList<Cookie> {
        return if (cookiesMap.containsKey(url)) cookiesMap[url]!! else Collections.emptyList()
    }

    private fun Cookie.hasExpired(): Boolean {
        return if (expiresAt() < 0) {
            true
        } else {
            expiresAt() < System.currentTimeMillis()
        }
    }

    private fun parseHost(host: String): HttpUrl {
        return HttpUrl.parse("http://" + host)!!
    }
}