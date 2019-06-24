package com.example.weatherapp.domain.commands

import com.example.weatherapp.data.server.ForecastRequest
import com.example.weatherapp.domain.ForecastDataMapper
import com.example.weatherapp.domain.model.ForecastList

/**
 * created by Sunday
 * on 2019-06-24 16:07
 */
class RequestForecastCommand (private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}