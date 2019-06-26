package com.example.weatherapp.data.server

import android.util.Log
import com.example.weatherapp.data.ForecastResult
import com.google.gson.Gson

/**
 * created by Sunday
 * on 2019-06-24 15:36
 */
class ForecastByZipCodeRequest(private val zipCode: Long) {
    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "$URL&APPID=$APP_ID&zip="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        Log.d("Sunday",forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}