package com.cpand4.kotlinapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cpand4.kotlinapp.R
import com.cpand4.kotlinapp.domain.commands.RequestForecastCommand
import com.cpand4.kotlinapp.domain.model.Forecast
import com.cpand4.kotlinapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = find(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result,
                    object: ForecastListAdapter.OnItemClickListener {
                        override fun invoke(forecast: Forecast) {
                            toast(forecast.date)
                        }
                    })
            }
        }
    }
}
