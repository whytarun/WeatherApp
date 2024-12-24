package com.tv.weatherapp.data.repository

import com.tv.weatherapp.data.mappers.toDomain
import com.tv.weatherapp.data.remote.WeatherApi
import com.tv.weatherapp.domain.manager.LocalCityManager
import com.tv.weatherapp.domain.repository.WeatherRepository
import com.tv.weatherapp.domain.util.Resource
import com.tv.weatherapp.domain.model.WeatherData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api :WeatherApi,
    private val localCityManager: LocalCityManager
) : WeatherRepository {
    override suspend fun getWeatherData(apiKey: String, city: String): Resource<WeatherData> {
        return try{
                Resource.Success(
                    data = api.getWeatherData(
                        apiKey = apiKey,
                        city = city
                    ).toDomain()
                )

        } catch (e :Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: " An unknown error occurred.")
        }
    }

    override suspend fun saveSelectedCity(weatherData: WeatherData) {
        localCityManager.saveSelectedCity(weatherData)
    }

    override suspend fun getSavedCity(): Flow<WeatherData?> {
        return localCityManager.getSavedCity()
    }
}