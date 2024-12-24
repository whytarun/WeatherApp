package com.tv.weatherapp.data.remote.dto

import com.squareup.moshi.Json

data class WeatherConditionDto(
    val text: String,
    val icon: String
)