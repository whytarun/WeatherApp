package com.tv.weatherapp.presentation.search

import com.tv.weatherapp.domain.model.WeatherData


data class SearchState(
    val searchQuery: String = "",
    val weatherData: WeatherData? = null,
    val isLoading :Boolean = false,
    val error :String? = null
)