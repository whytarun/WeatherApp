package com.tv.weatherapp.data.remote

import com.tv.weatherapp.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/current.json")
    suspend fun getWeatherData(
        @Query("key") apiKey :String,
        @Query("q") city :String
    ) : WeatherDto
}