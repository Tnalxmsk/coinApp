package com.example.cocoin

import android.app.Application
import timber.log.Timber

// Log 찍을 준비
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}