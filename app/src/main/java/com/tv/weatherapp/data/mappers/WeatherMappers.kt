package com.tv.weatherapp.data.mappers

import com.tv.weatherapp.data.remote.dto.WeatherDto
import com.tv.weatherapp.domain.model.WeatherData


fun WeatherDto.toDomain(): WeatherData {
    return WeatherData(
        cityName = location.name,
        temperature = current.temp_c,
        weatherCondition = current.condition.text,
        weatherIcon = current.condition.icon,
        humidity = current.humidity,
        uvIndex = current.uv,
        feelsLike = current.feelslike_c
    )
}