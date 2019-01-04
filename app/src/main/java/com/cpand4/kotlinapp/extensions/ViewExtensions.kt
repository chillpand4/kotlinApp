package com.cpand4.kotlinapp.extensions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by stefano on 02/01/2019.
 */

operator fun ViewGroup.get(position: Int): View = getChildAt(position)

val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}