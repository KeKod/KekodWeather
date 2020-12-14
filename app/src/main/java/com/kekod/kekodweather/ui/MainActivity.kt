package com.kekod.kekodweather.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kekod.kekodweather.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel =
            ViewModelProvider(this, MainViewModel.Factory()).get(MainViewModel::class.java)

        val txtWeatherDegree = findViewById<TextView>(R.id.txtWeatherDegree)

        mainViewModel.feelsLike.observe(this, {
            txtWeatherDegree.text = it
        })

        mainViewModel.errorWeatherByCityNameResponse.observe(this, {
            Toast.makeText(
                this@MainActivity,
                "KEKO $it",
                Toast.LENGTH_SHORT
            ).show()
        })

        txtWeatherDegree.setOnClickListener {
            mainViewModel.getWeatherByCityName("istanbul", "metric")
        }
    }
}