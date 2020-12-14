package com.kekod.kekodweather.data.repository

import com.kekod.kekodweather.data.network.api.WeatherAPIService
import com.kekod.kekodweather.data.network.response.WeatherByCityNameResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(private val weatherAPIService: WeatherAPIService) {

    fun getWeatherByCityName(
        cityName: String,
        unit: String,
        responseHandler: (WeatherByCityNameResponse?) -> Unit,
        errorHandler: (String?) -> Unit
    ) {
        weatherAPIService.getWeatherByCityName(cityName, unit).enqueue(object :
            Callback<WeatherByCityNameResponse> {
            override fun onResponse(
                call: Call<WeatherByCityNameResponse>,
                response: Response<WeatherByCityNameResponse>
            ) {
                responseHandler.invoke(response.body())
            }

            override fun onFailure(call: Call<WeatherByCityNameResponse>, t: Throwable) {
                errorHandler.invoke(t.message)
            }
        })
    }
}