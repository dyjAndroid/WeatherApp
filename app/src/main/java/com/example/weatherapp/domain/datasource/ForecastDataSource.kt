package com.example.weatherapp.domain.datasource

import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.model.ForecastList

/**
 * created by Sunday
 * on 2019-06-26 10:59
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}