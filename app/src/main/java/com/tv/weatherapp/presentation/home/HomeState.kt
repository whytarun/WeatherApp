package com.tv.weatherapp.presentation.home

import com.tv.weatherapp.domain.model.WeatherData

data class HomeState(
    val weatherData: WeatherData? = null,
    val isLoading :Boolean = false,
    val error :String? = null

)
