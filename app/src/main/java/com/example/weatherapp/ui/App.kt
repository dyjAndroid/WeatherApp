package com.example.weatherapp.ui

import android.app.Application

/**
 * created by Sunday
 * on 2019-06-24 20:02
 */
class App : Application() {

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}