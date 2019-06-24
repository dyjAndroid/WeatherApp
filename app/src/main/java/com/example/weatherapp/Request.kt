package com.example.weatherapp

import android.util.Log
import java.net.URL

/**
 * created by Sunday
 * on 2019-06-24 15:01
 */
class Request(private val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d("Sunday", forecastJsonStr)
    }

}