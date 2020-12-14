package com.kekod.kekodweather.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kekod.kekodweather.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel by viewModel()

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