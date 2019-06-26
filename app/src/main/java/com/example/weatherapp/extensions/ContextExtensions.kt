package com.example.weatherapp.extensions

import android.content.Context
import androidx.core.content.ContextCompat

/**
 * created by Sunday
 * on 2019-06-26 14:19
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)