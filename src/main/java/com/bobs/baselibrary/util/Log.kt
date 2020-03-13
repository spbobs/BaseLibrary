package com.bobs.baselibrary.util

import android.util.Log
import com.bobs.baselibrary.BuildConfig

const val TAG = "BOBS"

fun logv(msg: String) {
    if (BuildConfig.DEBUG)
        Log.v(TAG, msg)
}

fun logd(msg: String) {
    if (BuildConfig.DEBUG)
        Log.d(TAG, msg)
}

fun logi(msg: String) {
    if (BuildConfig.DEBUG)
        Log.i(TAG, msg)
}

fun logw(msg: String) {
    if (BuildConfig.DEBUG)
        Log.w(TAG, msg)
}

fun loge(msg: String) {
    if (BuildConfig.DEBUG)
        Log.e(TAG, msg)
}
