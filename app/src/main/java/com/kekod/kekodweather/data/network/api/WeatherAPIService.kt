package com.kekod.kekodweather.data.network.api

import com.kekod.kekodweather.data.network.response.WeatherByCityNameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {
    @GET("weather?appid=a17e19e4c74080d24b6ae73462525a99")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String,
        @Query("units") unit: String
    ): WeatherByCityNameResponse
}