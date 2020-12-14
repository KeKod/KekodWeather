package com.kekod.kekodweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kekod.kekodweather.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class MainViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val mutableFeelsLike = MutableLiveData<String>()
    val feelsLike: LiveData<String>
        get() = mutableFeelsLike

    private val mutableErrorWeatherByCityNameResponse = MutableLiveData<String>()
    val errorWeatherByCityNameResponse: LiveData<String>
        get() = mutableErrorWeatherByCityNameResponse

    fun getWeatherByCityName(cityName: String, unit: String) {
        viewModelScope.launch {
            try {
                val weatherByCityNameResponse =
                    weatherRepository.getWeatherByCityName(cityName, unit)
                weatherByCityNameResponse.main.feels_like.let {
                    mutableFeelsLike.value = it.toString()
                }
            } catch (exception: Exception) {
                mutableErrorWeatherByCityNameResponse.value = exception.message
            }
        }
    }
}