package com.cpand4.kotlinapp.domain.datasource

import com.cpand4.kotlinapp.domain.model.Forecast
import com.cpand4.kotlinapp.domain.model.ForecastList

/**
 * Created by stefano on 03/01/2019.
 */

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}