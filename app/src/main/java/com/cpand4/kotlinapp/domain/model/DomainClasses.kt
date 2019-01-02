package com.cpand4.kotlinapp.domain.model

/**
 * Created by stefano on 24/12/2018.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)