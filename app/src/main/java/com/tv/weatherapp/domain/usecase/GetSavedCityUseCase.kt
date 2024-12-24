package com.tv.weatherapp.domain.usecase

import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedCityUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(): Flow<WeatherData?>{
        return weatherRepository.getSavedCity()
    }
}