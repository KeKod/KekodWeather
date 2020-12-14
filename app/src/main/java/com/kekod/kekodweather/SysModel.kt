package com.kekod.kekodweather

data class SysModel(
    val type: Int,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)