package com.cpand4.kotlinapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by stefano on 03/01/2019.
 */

fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)