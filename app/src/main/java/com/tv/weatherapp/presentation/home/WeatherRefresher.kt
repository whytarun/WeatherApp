package com.tv.weatherapp.presentation.home

import com.tv.weatherapp.domain.usecase.GetCityWeatherUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherRefresher @Inject constructor(
    private val getCityWeatherUseCase: GetCityWeatherUseCase
) {

    var lastFeelsLike: Double = 0.0

    fun refresh(cityName: String) {
        GlobalScope.launch {
            val resource = getCityWeatherUseCase(cityName)
            val weatherData = resource.data!!
            lastFeelsLike = weatherData.feelsLike!!
        }
    }
}
