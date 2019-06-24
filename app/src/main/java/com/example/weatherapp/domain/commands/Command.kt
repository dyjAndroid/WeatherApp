package com.example.weatherapp.domain.commands

/**
 * created by Sunday
 * on 2019-06-24 15:43
 */
interface Command<T> {
    fun execute(): T
}