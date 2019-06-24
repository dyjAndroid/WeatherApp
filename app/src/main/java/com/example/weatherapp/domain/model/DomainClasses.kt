package com.example.weatherapp.domain.model

/**
 * created by Sunday
 * on 2019-06-24 15:45
 */
data class ForecastList(val city: String, val country: String,val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)