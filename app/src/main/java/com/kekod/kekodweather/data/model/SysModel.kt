package com.kekod.kekodweather.data.model

data class SysModel(
    val type: Int,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)