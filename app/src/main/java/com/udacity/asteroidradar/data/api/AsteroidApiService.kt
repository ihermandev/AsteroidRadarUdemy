package com.udacity.asteroidradar.data.api

import com.udacity.asteroidradar.Constants.FEED_URL
import com.udacity.asteroidradar.Constants.IMAGE_OF_DAY_URL
import com.udacity.asteroidradar.Constants.nasaApiKey
import retrofit2.http.GET
import retrofit2.http.Query


interface AsteroidApiService {
    @GET(FEED_URL)
    suspend fun getAsteroids(
        @Query("start_date") startData: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = nasaApiKey
    ): String

    @GET(IMAGE_OF_DAY_URL)
    suspend fun getImgOfDayData(
        @Query("api_key") apiKey: String = nasaApiKey
    ): NetworkPictureOfDay
}

