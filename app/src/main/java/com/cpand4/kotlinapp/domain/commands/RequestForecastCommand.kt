package com.cpand4.kotlinapp.domain.commands

import com.cpand4.kotlinapp.domain.mappers.ForecastDataMapper
import com.cpand4.kotlinapp.domain.model.ForecastList
import com.cpand4.kotlinapp.data.ForecastRequest

/**
 * Created by stefano on 24/12/2018.
 */

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}