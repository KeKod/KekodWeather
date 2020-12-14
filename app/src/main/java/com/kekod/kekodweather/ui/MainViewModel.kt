package com.kekod.kekodweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kekod.kekodweather.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class MainViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    val feelsLike = MutableLiveData<String>()
    val errorWeatherByCityNameResponse = MutableLiveData<String>()

    fun getWeatherByCityName(cityName: String, unit: String) {
        viewModelScope.launch {
            try {
                val weatherByCityNameResponse =
                    weatherRepository.getWeatherByCityName(cityName, unit)
                weatherByCityNameResponse.main.feels_like.let {
                    feelsLike.value = it.toString()
                }
            } catch (exception: Exception) {
                errorWeatherByCityNameResponse.value = exception.message
            }
        }
    }
}