package com.kekod.kekodweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kekod.kekodweather.data.repository.WeatherRepository

class MainViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    val feelsLike = MutableLiveData<String>()
    val errorWeatherByCityNameResponse = MutableLiveData<String>()

    fun getWeatherByCityName(cityName: String, unit: String) {
        weatherRepository.getWeatherByCityName(cityName, unit, {
            feelsLike.value = it?.main?.feels_like.toString()
        }, {
            errorWeatherByCityNameResponse.value = it
        })
    }
}