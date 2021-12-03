package com.udacity.asteroidradar.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.Constants.IMAGE_MEDIA_TYPE
import com.udacity.asteroidradar.Constants.nasaApiKey
import com.udacity.asteroidradar.data.api.*
import com.udacity.asteroidradar.data.database.AsteroidsDatabase
import com.udacity.asteroidradar.data.database.asDomainModel
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.domain.PictureOfDay
import com.udacity.asteroidradar.domain.asDataBaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import timber.log.Timber

class AsteroidRepository(
    private val api: AsteroidApiService = AsteroidApiInjector.retrofitService,
    private val database: AsteroidsDatabase
) {

    val pictureOfDay: LiveData<PictureOfDay> =
        Transformations.map(database.pictureDao.getPictureOFDay()) {
            it?.asDomainModel()
        }

    val asteroids: LiveData<List<Asteroid>> =
        Transformations.map(database.asteroidDao.getAsteroids()) {
            it?.asDomainModel()
        }

    suspend fun updatePictureOfDay() {
        withContext(Dispatchers.IO) {
            try {
                val picture = api.getImgOfDayData()
                if (picture.mediaType == IMAGE_MEDIA_TYPE) {
                    database.pictureDao.insertPicture(picture.asDataBaseModel())
                }
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }

    suspend fun updateAsteroids() {
        withContext(Dispatchers.IO) {
            try {
                val asteroids = api.getAsteroids(
                    startData = startDate(),
                    endDate = endDate(),
                    apiKey = nasaApiKey
                )
                val result = parseAsteroidsJsonResult(JSONObject(asteroids))
                database.asteroidDao.insertAll(*result.asDataBaseModel())
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }

    private fun handleError(e: Exception) {
        Timber.e(e.message)
    }

}
