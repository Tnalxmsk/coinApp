package com.example.cocoin.util

import android.app.Application
import android.content.Context
import timber.log.Timber

// Log 찍을 준비
class App : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance : App? = null
        fun context() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}