package com.kekod.kekodweather.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        val baseURL = "https://api.openweathermap.org/data/2.5/"

        @Volatile
        private var INSTANCE: Retrofit? = null
        fun getRetrofit(): Retrofit {
            synchronized(this) {
                INSTANCE?.let {
                    return it
                }

                INSTANCE = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return INSTANCE as Retrofit
            }
        }
    }
}