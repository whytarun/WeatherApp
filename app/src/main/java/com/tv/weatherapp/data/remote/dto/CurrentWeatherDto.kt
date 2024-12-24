package com.tv.weatherapp.data.remote.dto

import com.squareup.moshi.Json

class CurrentWeatherDto(
    val temp_c: Double?,
    val condition: WeatherConditionDto,
    val humidity: Int?,
    val uv: Double?,
    val feelslike_c: Double?
)