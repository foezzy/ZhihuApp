package com.example.zhihuapp.utils

import com.blankj.utilcode.util.LogUtils

fun String?.logD(tag: String) {
    LogUtils.d(tag, this)
}

fun String?.logE(tag: String) {
    LogUtils.e(tag, this)
}