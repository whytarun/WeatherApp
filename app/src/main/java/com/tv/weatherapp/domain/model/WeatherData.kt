package com.tv.weatherapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


data class WeatherData(
    val cityName: String,
    val temperature: Double?,
    val weatherCondition: String,
    val weatherIcon: String,
    val humidity: Int?,
    val uvIndex: Double?,
    val feelsLike: Double?
){
    val fullWeatherIcon: String
        get() = if(weatherIcon.startsWith("http")) weatherIcon else "https:$weatherIcon"
}
