package com.example.weatherapp.domain.commands

import com.example.weatherapp.data.server.ForecastByZipCodeRequest
import com.example.weatherapp.data.server.ServerDataMapper
import com.example.weatherapp.domain.datasource.ForecastProvider
import com.example.weatherapp.domain.model.ForecastList

/**
 * created by Sunday
 * on 2019-06-24 16:07
 */
class RequestForecastCommand(
    private val zipCode: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}