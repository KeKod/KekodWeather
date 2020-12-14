package com.kekod.kekodweather.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kekod.kekodweather.R
import com.kekod.kekodweather.data.network.api.WeatherAPI
import com.kekod.kekodweather.data.network.response.WeatherByCityNameResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtWeatherDegree = findViewById<TextView>(R.id.txtWeatherDegree)

        val baseURL = "https://api.openweathermap.org/data/2.5/"
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherAPI: WeatherAPI = retrofit.create(WeatherAPI::class.java)

        val weatherByCityNameResponse: Call<WeatherByCityNameResponse> =
            weatherAPI.getWeatherByCityName("istanbul", "metric")

        weatherByCityNameResponse.enqueue(object : Callback<WeatherByCityNameResponse> {
            override fun onResponse(
                call: Call<WeatherByCityNameResponse>,
                response: Response<WeatherByCityNameResponse>
            ) {
                response.body()?.let {
                    txtWeatherDegree.text = it.main.feels_like.toString()
                }
            }

            override fun onFailure(call: Call<WeatherByCityNameResponse>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "KEKO ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}