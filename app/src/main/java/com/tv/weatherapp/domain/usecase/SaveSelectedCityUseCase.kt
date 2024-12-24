package com.tv.weatherapp.domain.usecase

import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class SaveSelectedCityUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(weatherData: WeatherData){
        weatherRepository.saveSelectedCity(weatherData)
    }
}