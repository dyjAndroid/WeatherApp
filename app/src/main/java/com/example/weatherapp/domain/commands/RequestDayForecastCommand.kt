package com.example.weatherapp.domain.commands

import com.example.weatherapp.domain.datasource.ForecastProvider
import com.example.weatherapp.domain.model.Forecast

/**
 * created by Sunday
 * on 2019-06-26 13:45
 */
class RequestDayForecastCommand(val id: Long, private val forecastProvider: ForecastProvider = ForecastProvider()) :
    Command<Forecast> {
    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}