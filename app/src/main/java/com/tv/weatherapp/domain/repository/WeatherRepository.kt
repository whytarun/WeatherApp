package com.tv.weatherapp.domain.repository

import com.tv.weatherapp.domain.util.Resource
import com.tv.weatherapp.domain.model.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
     suspend fun getWeatherData( apiKey :String, city :String) :Resource<WeatherData>
     suspend fun saveSelectedCity(weatherData: WeatherData)
     suspend fun getSavedCity(): Flow<WeatherData?>
}