package com.udacity.asteroidradar

import android.app.Application
import timber.log.Timber

class AsteroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        setupLogger()
    }

    private fun setupLogger() {
        Timber.plant(Timber.DebugTree())
    }
}
