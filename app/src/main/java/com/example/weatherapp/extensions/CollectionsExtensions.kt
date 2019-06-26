package com.example.weatherapp.extensions

/**
 * created by Sunday
 * on 2019-06-26 10:33
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
    map { Pair(it.key, it.value!!) }.toTypedArray()