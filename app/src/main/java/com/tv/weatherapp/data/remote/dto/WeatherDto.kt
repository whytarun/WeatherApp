package com.tv.weatherapp.data.remote.dto

data class WeatherDto (
    val location : LocationDto,
    val current : CurrentWeatherDto
)