package com.udacity.asteroidradar.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.udacity.asteroidradar.data.api.todayDate
import com.udacity.asteroidradar.data.database.getDatabase
import com.udacity.asteroidradar.data.repository.AsteroidRepository
import retrofit2.HttpException
import timber.log.Timber

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        Timber.i("RefreshDataWorker is running")
        val database = getDatabase(applicationContext)
        val repository = AsteroidRepository(database = database)
        return try {
            repository.apply {
                deleteAsteroidsBeforeDate(todayDate())
                updateAsteroids()
                updatePictureOfDay()
            }
            Timber.i("Success $WORK_NAME job")
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        } catch (e: Exception) {
            Timber.i("Failure job")
            Result.failure()
        }
    }

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }
}

