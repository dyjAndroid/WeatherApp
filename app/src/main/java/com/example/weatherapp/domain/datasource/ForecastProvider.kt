package com.example.weatherapp.domain.datasource

import com.example.weatherapp.data.db.ForecastDb
import com.example.weatherapp.data.server.ForecastServer
import com.example.weatherapp.domain.model.ForecastList
import com.example.weatherapp.extensions.firstResult

/**
 * created by Sunday
 * on 2019-06-26 11:00
 */
class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList =
        sources.firstResult {
            requestSource(it, days, zipCode)
        }

    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS
}