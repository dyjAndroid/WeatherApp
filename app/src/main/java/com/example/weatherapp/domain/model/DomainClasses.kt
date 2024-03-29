package com.example.weatherapp.domain.model

/**
 * created by Sunday
 * on 2019-06-24 15:45
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {

    operator fun get(position: Int) = dailyForecast[position]

    fun size() = dailyForecast.size
}

data class Forecast(
    val id: Long, val date: Long, val description: String, val high: Int,
    val low: Int, val iconUrl: String
)