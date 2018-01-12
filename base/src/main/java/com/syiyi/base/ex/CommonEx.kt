package com.syiyi.base.ex

import android.content.Context
import android.widget.Toast

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
