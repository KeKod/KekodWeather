package com.kekod.kekodweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kekod.kekodweather.data.repository.WeatherRepository

class MainViewModel : ViewModel() {
    private val weatherRepository = WeatherRepository()

    val feelsLike = MutableLiveData<String>()
    val errorWeatherByCityNameResponse = MutableLiveData<String>()

    fun getWeatherByCityName(cityName: String, unit: String) {
        weatherRepository.getWeatherByCityName(cityName, unit, {
            feelsLike.value = it?.main?.feels_like.toString()
        }, {
            errorWeatherByCityNameResponse.value = it
        })
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel() as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}