package com.kekod.kekodweather.data.repository

import com.kekod.kekodweather.data.network.api.WeatherAPIService
import com.kekod.kekodweather.data.network.response.WeatherByCityNameResponse

class WeatherRepository(private val weatherAPIService: WeatherAPIService) {
    suspend fun getWeatherByCityName(
        cityName: String,
        unit: String,
    ): WeatherByCityNameResponse = weatherAPIService.getWeatherByCityName(cityName, unit)
}