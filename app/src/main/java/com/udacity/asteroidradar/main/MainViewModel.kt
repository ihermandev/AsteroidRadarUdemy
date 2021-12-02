package com.udacity.asteroidradar.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.repository.AsteroidRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val repository = AsteroidRepository()

    private val _pictureOfDayUrl = MutableLiveData<String>()

    val pictureOfDayUrl: LiveData<String>
        get() = _pictureOfDayUrl

    init {
        getPictureOFDayData()
        getAsteroids()
    }

    fun getAsteroids() {
        viewModelScope.launch {
            repository.getAsteroids()
        }
    }

    fun getPictureOFDayData() {
        viewModelScope.launch {
            try {
                _pictureOfDayUrl.value = repository.getPictureOFDay().url
            } catch (e: Exception) {
                handleError(e)
            }

        }
    }

    private fun handleError(e: Exception) {
        Timber.e(e)
    }
}
