package com.nik.cleanweather.data.repository

import com.nik.cleanweather.data.mappers.toWeatherInfo
import com.nik.cleanweather.data.remote.WeatherApi
import com.nik.cleanweather.domain.repository.WeatherRepository
import com.nik.cleanweather.domain.util.Resource
import com.nik.cleanweather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}