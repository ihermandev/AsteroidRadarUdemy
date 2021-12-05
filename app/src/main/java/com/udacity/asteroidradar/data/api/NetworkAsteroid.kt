package com.udacity.asteroidradar.data.api

import com.squareup.moshi.Json

data class NetworkAsteroid(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val codename: String,
    @Json(name = "close_approach_data") val closeApproachDate: String,
    @Json(name = "absolute_magnitude") val absoluteMagnitude: Double,
    @Json(name = "estimated_diameter_max") val estimatedDiameter: Double,
    @Json(name = "relative_velocity") val relativeVelocity: Double,
    @Json(name = "miss_distance") val distanceFromEarth: Double,
    @Json(name = "is_potentially_hazardous_asteroid") val isPotentiallyHazardous: Boolean
)

