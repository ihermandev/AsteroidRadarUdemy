package com.udacity.asteroidradar.work

import android.os.Build
import androidx.work.*
import java.util.concurrent.TimeUnit

object RefreshDataConfigurator {

    private val defConstraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED)
        .setRequiresBatteryNotLow(true)
        .setRequiresCharging(true)
        .apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                setRequiresDeviceIdle(true)
            }
        }.build()

//    fun setupRecurringWork(constraints: Constraints = defConstraints) {
//        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.DAYS)
//            .setConstraints(constraints)
//            .build()
//
//        WorkManager.getInstance().enqueueUniquePeriodicWork(
//            RefreshDataWorker.WORK_NAME,
//            ExistingPeriodicWorkPolicy.KEEP,
//            repeatingRequest
//        )
//    }

}
