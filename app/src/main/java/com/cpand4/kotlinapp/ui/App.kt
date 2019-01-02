package com.cpand4.kotlinapp.ui

import android.app.Application
import com.cpand4.kotlinapp.ui.utils.DelegatesExt

/**
 * Created by stefano on 02/01/2019.
 */

class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}