package com.nik.cleanweather.domain.repository

import com.nik.cleanweather.domain.util.Resource
import com.nik.cleanweather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double) : Resource<WeatherInfo>
}