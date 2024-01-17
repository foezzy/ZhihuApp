package com.example.zhihuapp.config

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.example.zhihuapp.App
import com.example.zhihuapp.R
import java.util.ArrayList
import java.util.Arrays

object ColorConfig {

    fun initColors() {
        initBgColors()
        initReadingBgColors()
    }

    var bgColors = arrayListOf<Int>()

    fun initBgColors() {
        bgColors.add(App.getContext().getColor(R.color.color_bg_1))
        bgColors.add(App.getContext().getColor(R.color.color_bg_2))
        bgColors.add(App.getContext().getColor(R.color.color_bg_3))
        bgColors.add(App.getContext().getColor(R.color.color_bg_4))
        bgColors.add(App.getContext().getColor(R.color.color_bg_5))
        bgColors.add(App.getContext().getColor(R.color.color_bg_6))
        bgColors.add(App.getContext().getColor(R.color.color_bg_7))
    }

    fun getRadomBgColor(): Int {
        val rIndex = (0..bgColors.size - 1).random()
        return bgColors.get(rIndex)
    }


    var bgReadingColors = arrayListOf<String>()

    fun initReadingBgColors() {
        var l = App.getContext().resources.getStringArray(R.array.readingBgArr)
        l.forEach {
            bgReadingColors.add(it)
        }
    }

    fun getRadomReadingBgColor(): Int {
        val rIndex = (0..bgReadingColors.size - 1).random()
//        return bgReadingColors.get(rIndex)
        return 0
    }

    fun getOrderReadingBgColor(pos: Int): Int {
        val oIndex = pos % bgReadingColors.size
        return Color.parseColor(bgReadingColors.get(oIndex))
    }
}