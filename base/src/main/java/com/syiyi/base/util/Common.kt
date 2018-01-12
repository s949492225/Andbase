package com.syiyi.base.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.view.inputmethod.InputMethodManager
import com.syiyi.base.ContextHolder

/**
 * 通用的工具类
 * Created by songlintao on 2018/1/11.
 */
fun hideSoftInput(activity: Activity) {
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (imm.isActive && activity.currentFocus != null) {
        if (activity.currentFocus.windowToken != null) {
            imm.hideSoftInputFromWindow(activity.currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}

fun getVersionCode(): Int {
    var versionCode = 0
    try {
        val packInfo = ContextHolder.context.packageManager.getPackageInfo(getPackageName(), PackageManager.GET_CONFIGURATIONS)
        versionCode = packInfo.versionCode
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return versionCode
}

fun getPackageName(): String {
    var sPackageName = ContextHolder.context.packageName
    if (sPackageName.indexOf(":") >= 0) {
        sPackageName = sPackageName.substring(0, sPackageName.lastIndexOf(":"))
    }
    return sPackageName
}