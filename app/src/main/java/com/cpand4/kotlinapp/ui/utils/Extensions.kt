package com.cpand4.kotlinapp.ui.utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by stefano on 24/12/2018.
 */

fun Context.message(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

operator fun ViewGroup.get(position: Int): View = getChildAt(position)

val View.ctx: Context
    get() = context