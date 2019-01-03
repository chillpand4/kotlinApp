package com.cpand4.kotlinapp.domain.commands

import com.cpand4.kotlinapp.domain.datasource.ForecastProvider
import com.cpand4.kotlinapp.domain.model.Forecast

/**
 * Created by stefano on 03/01/2019.
 */

class RequestDayForecastCommand(val id: Long,
                                private val forecastProvider: ForecastProvider = ForecastProvider()) :
    Command<Forecast> {

    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}