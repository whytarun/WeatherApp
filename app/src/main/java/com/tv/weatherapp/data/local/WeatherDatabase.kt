package com.tv.weatherapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tv.weatherapp.domain.model.WeatherData

@Database(entities = [WeatherData::class], version = 1)
abstract class WeatherDatabase :RoomDatabase() {
    abstract val weatherDao :WeatherDao
}
