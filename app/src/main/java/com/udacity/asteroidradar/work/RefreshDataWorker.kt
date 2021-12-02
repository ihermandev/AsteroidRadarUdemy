package com.udacity.asteroidradar.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import retrofit2.HttpException
import timber.log.Timber

class RefreshDataWorker(appContext: Context, params: WorkerParameters)
//    : CoroutineWorker(appContext, params)
{
//    override suspend fun doWork(): Result {
//        //TODO need to be implemented
////        Timber.i("RefreshDataWorker is running")
////        val database = getDatabase(applicationContext)
////        val repository = VideosRepository(database)
////        return try {
////            repository.refreshVideos()
////            Result.success()
////        } catch (e: HttpException) {
////            Result.retry()
////        }
//    }

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }
}

