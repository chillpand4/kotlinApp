package com.cpand4.kotlinapp.domain.datasource

import com.cpand4.kotlinapp.data.db.ForecastDb
import com.cpand4.kotlinapp.data.server.ForecastServer
import com.cpand4.kotlinapp.domain.model.ForecastList
import com.cpand4.kotlinapp.extensions.firstResult

/**
 * Created by stefano on 03/01/2019.
 */

class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        const val DAY_IN_MILLIS = 1000*60*60*24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = sources.firstResult { requestSource(it, days, zipCode) }

    fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}