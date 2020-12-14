package com.kekod.kekodweather.data.network.response

import com.kekod.kekodweather.data.model.*

data class WeatherByCityNameResponse(
    val coord: CoordModel,
    val weather: List<WeatherModel>,
    val base: String,
    val main: MainModel,
    val visibility: Int,
    val wind: WindModel,
    val clouds: CloudsModel,
    val dt: Long,
    val sys: SysModel,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int
)