package com.cpand4.kotlinapp.data.server

import com.cpand4.kotlinapp.data.db.ForecastDb
import com.cpand4.kotlinapp.domain.datasource.ForecastDataSource
import com.cpand4.kotlinapp.domain.model.ForecastList

/**
 * Created by stefano on 03/01/2019.
 */

class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
    private val forecastDb: ForecastDb = ForecastDb()): ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()
}