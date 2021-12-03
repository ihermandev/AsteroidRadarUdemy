package com.udacity.asteroidradar.data.api

import com.squareup.moshi.Json
import com.udacity.asteroidradar.data.database.DataBasePicture
import com.udacity.asteroidradar.domain.PictureOfDay

data class NetworkPictureOfDay(
    @Json(name = "media_type") val mediaType: String,
    val title: String,
    val url: String
)

fun NetworkPictureOfDay.asDataBaseModel(): DataBasePicture {
    return DataBasePicture(url = url, title = title)
}

fun NetworkPictureOfDay.asDomainModel(): PictureOfDay {
    return PictureOfDay(url = url, title = title)
}
