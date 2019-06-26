package com.example.weatherapp.extensions

import java.text.DateFormat
import java.util.*

/**
 * created by Sunday
 * on 2019-06-26 14:09
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}