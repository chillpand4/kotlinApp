package com.cpand4.kotlinapp.extensions

import android.content.Context
import android.view.View
import android.view.ViewGroup

/**
 * Created by stefano on 02/01/2019.
 */

operator fun ViewGroup.get(position: Int): View = getChildAt(position)

val View.ctx: Context
    get() = context