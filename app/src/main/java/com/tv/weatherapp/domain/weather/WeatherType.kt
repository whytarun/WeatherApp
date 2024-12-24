package com.tv.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.tv.weatherapp.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    data object ClearSky : WeatherType(
        weatherDesc = "Clear Sky",
        iconRes = R.drawable.ic_sunny
    )

    data object SunnyCloudy : WeatherType(
         weatherDesc = "Sunny Cloudy",
        iconRes = R.drawable.ic_sunnycloudy
    )

   data object Cloudy : WeatherType(
        weatherDesc = "Cloudy",
        iconRes = R.drawable.ic_cloudy
    )

    companion object{
        fun fromWMO(code:Int ): WeatherType {
            return when(code){
                0 -> ClearSky
                1 -> SunnyCloudy
                2 -> Cloudy
                else -> ClearSky
            }
        }
    }
}