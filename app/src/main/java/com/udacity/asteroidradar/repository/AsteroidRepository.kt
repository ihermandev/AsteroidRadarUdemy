package com.udacity.asteroidradar.repository

import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants.nasaApiKey
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.api.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import java.util.ArrayList

class AsteroidRepository(
    private val api: AsteroidApiService = AsteroidApi.retrofitService,

    ) {

    suspend fun getAsteroids() {
        withContext(Dispatchers.IO) {
            try {
                val asteroids = api.getAsteroids(
                    startData = startDate(),
                    endDate = endDate(),
                    apiKey = nasaApiKey
                )
                val result = parseAsteroidsJsonResult(JSONObject(asteroids))
                println(result)

            } catch (e: Exception) {
            }
        }
    }

    suspend fun getPictureOFDay(): PictureOfDay {
        return api.getImgOfDayData()
    }
}
