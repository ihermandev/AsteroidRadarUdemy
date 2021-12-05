package com.udacity.asteroidradar

import android.app.Application
import com.udacity.asteroidradar.work.RefreshDataConfigurator.setupRecurringWork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class AsteroidApplication : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    private fun delayedInit() = applicationScope.launch {
        setupRecurringWork(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        setupLogger()
        delayedInit()
    }

    private fun setupLogger() {
        Timber.plant(Timber.DebugTree())
    }
}
