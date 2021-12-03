package com.udacity.asteroidradar.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.data.database.getDatabase
import com.udacity.asteroidradar.data.repository.AsteroidRepository
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.domain.PictureOfDay
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)

    private val repository = AsteroidRepository(database = database)

    init {
        Timber.d("init block called")
        viewModelScope.launch {
            repository.apply {
                updatePictureOfDay()
                updateAsteroids()
            }
        }
    }

    private val _pictureOfDayUrl = repository.pictureOfDay
    val pictureOfDayUrl: LiveData<PictureOfDay>
        get() = _pictureOfDayUrl

    private val _asteroids = repository.asteroids
    val asteroids: LiveData<List<Asteroid>>
        get() = _asteroids

    private fun handleError(e: Exception) {
        Timber.e(e)
    }
}
