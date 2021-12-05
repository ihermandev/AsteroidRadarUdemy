package com.udacity.asteroidradar

object Constants {
    const val API_QUERY_DATE_FORMAT = "yyyy-MM-dd"
    const val DEFAULT_END_DATE_DAYS = 7

    //Network
    const val BASE_URL = "https://api.nasa.gov/"
    const val FEED_URL = "neo/rest/v1/feed"
    const val nasaApiKey = BuildConfig.NASA_API_KEY
    const val IMAGE_OF_DAY_URL = "planetary/apod"

    //Database
    const val DATABASE_NAME = "asteroids_base"
    const val PICTURE_TABLE = "pictures"
    const val ASTEROID_TABLE = "asteroids"

    //Media type
    const val IMAGE_MEDIA_TYPE = "image"
}
