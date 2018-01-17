package com.syiyi.base.ex

import android.content.Context
import android.graphics.Point
import android.widget.Toast
import android.view.WindowManager


/**
 * 公共的扩展类
 * Created by songlintao on 2018/1/12.
 */

fun Context.toastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.dp2px(dp: Float): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun Context.px2dp(px: Int): Int {
    val scale = resources.displayMetrics.density
    return (px / scale + 0.5f).toInt()
}

fun Context.screenSize(): Point {
    val point = Point()
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    wm.defaultDisplay.getSize(point)
    return point
}


