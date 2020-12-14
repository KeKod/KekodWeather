package com.kekod.kekodweather

data class WeatherModel(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)