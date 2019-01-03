package com.cpand4.kotlinapp.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by stefano on 03/01/2019.
 */

fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}