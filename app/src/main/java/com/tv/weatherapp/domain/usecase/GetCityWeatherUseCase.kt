package com.tv.weatherapp.domain.usecase

import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.domain.repository.WeatherRepository
import com.tv.weatherapp.domain.util.Resource
import com.tv.weatherapp.util.Constants
import javax.inject.Inject

class GetCityWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
){
        suspend operator fun invoke( cityName:String):Resource<WeatherData>{
            return weatherRepository.getWeatherData(Constants.API_KEY, cityName)
        }
}