package com.example.weatherapp.data.server

import com.example.weatherapp.data.Forecast
import com.example.weatherapp.data.ForecastResult
import com.example.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.example.weatherapp.domain.model.Forecast as ModelForecast

/**
 * created by Sunday
 * on 2019-06-24 15:49
 */
class ServerDataMapper {

    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name,city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map {
            convertForecastItemToDomain(it)
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
            -1,forecast.dt, forecast.weather[0].description,
            forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon)
        )
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}