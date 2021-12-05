package com.udacity.asteroidradar.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.udacity.asteroidradar.data.AsteroidsDataFilter
import com.udacity.asteroidradar.data.api.todayDate
import com.udacity.asteroidradar.data.database.getDatabase
import com.udacity.asteroidradar.data.repository.AsteroidRepository
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

    private val _asteroids = MutableLiveData(AsteroidsDataFilter.SAVED_ASTEROIDS)
    val asteroids = Transformations.switchMap(_asteroids) { filter ->
        when (filter) {
            AsteroidsDataFilter.WEEK_ASTEROIDS -> {
                repository.weekAsteroids
            }
            AsteroidsDataFilter.TODAY_ASTEROIDS -> {
                repository.todayAsteroids
            }
            else -> {
                repository.savedAsteroids
            }
        }
    }

    fun clearPictureOfDayTable() {
        viewModelScope.launch {
            repository.clearImageOfDayData()
        }
    }

    fun clearAsteroidsTable() {
        viewModelScope.launch {
            repository.clearAsteroidsData()
        }
    }

    fun deleteAsteroidsBeforeDate(date: String = todayDate()) {
        viewModelScope.launch {
            repository.deleteAsteroidsBeforeDate(date)
        }
    }

    fun updateFilter(filter: AsteroidsDataFilter) {
        _asteroids.postValue(filter)
    }

    private fun handleError(e: Exception) {
        Timber.e(e)
    }
}
