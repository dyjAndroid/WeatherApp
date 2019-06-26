package com.example.weatherapp.data.server

import com.example.weatherapp.data.db.ForecastDb
import com.example.weatherapp.domain.datasource.ForecastDataSource
import com.example.weatherapp.domain.model.ForecastList

/**
 * created by Sunday
 * on 2019-06-26 11:22
 */
class ForecastServer(
    private val dataMapper: ServerDataMapper = ServerDataMapper(),
    private val forecastDb: ForecastDb = ForecastDb()
) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }
}