package com.kekod.kekodweather.app

import android.app.Application
import com.kekod.kekodweather.di.applicationModule
import com.kekod.kekodweather.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApp)
            modules(
                listOf(
                    applicationModule,
                    viewModelModule
                )
            )
        }
    }
}