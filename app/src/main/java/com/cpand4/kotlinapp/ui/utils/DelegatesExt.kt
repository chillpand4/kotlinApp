package com.cpand4.kotlinapp.ui.utils

import kotlin.reflect.KProperty

/**
 * Created by stefano on 02/01/2019.
 */

object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T> {

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value ?: throw IllegalStateException("${property.name} " + "not initialized")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} " + "already initialized")
    }
}