package com.syiyi.base.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

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