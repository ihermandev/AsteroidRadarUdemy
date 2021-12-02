package com.udacity.asteroidradar.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Constants.BASE_URL
import com.udacity.asteroidradar.Constants.FEED_URL
import com.udacity.asteroidradar.Constants.IMAGE_OF_DAY_URL
import com.udacity.asteroidradar.Constants.nasaApiKey
import com.udacity.asteroidradar.PictureOfDay
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


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
    ): PictureOfDay

}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val scalars = ScalarsConverterFactory
    .create()

private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .readTimeout(1, TimeUnit.MINUTES)
    .connectTimeout(1, TimeUnit.MINUTES)
    .build()


private val retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .addConverterFactory(scalars)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


object AsteroidApi {
    val retrofitService: AsteroidApiService by lazy {
        retrofit.create(
            AsteroidApiService::class.java
        )
    }
}
