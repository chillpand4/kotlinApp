package com.cpand4.kotlinapp.extensions

/**
 * Created by stefano on 02/01/2019.
 */

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> = map { Pair(it.key, it.value!!) }.toTypedArray()