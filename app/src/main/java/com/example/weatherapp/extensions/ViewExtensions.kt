package com.example.weatherapp.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * created by Sunday
 * on 2019-06-24 18:17
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}