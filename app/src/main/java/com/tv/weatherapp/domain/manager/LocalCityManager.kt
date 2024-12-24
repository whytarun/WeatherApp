package com.tv.weatherapp.domain.manager

import com.tv.weatherapp.domain.model.WeatherData
import kotlinx.coroutines.flow.Flow

interface LocalCityManager {
    suspend fun saveSelectedCity(weatherData: WeatherData)
    suspend fun getSavedCity(): Flow<WeatherData?>
}