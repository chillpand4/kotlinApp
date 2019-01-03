package com.cpand4.kotlinapp.domain.commands

import com.cpand4.kotlinapp.domain.model.ForecastList
import com.cpand4.kotlinapp.domain.datasource.ForecastProvider

/**
 * Created by stefano on 24/12/2018.
 */

class RequestForecastCommand(private val zipCode: Long,
                             private val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute(): ForecastList =
            forecastProvider.requestByZipCode(zipCode, DAYS)
}