package com.tv.weatherapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tv.weatherapp.domain.model.WeatherData
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(weatherData: WeatherData)

    @Delete
    suspend fun delete(weatherData: WeatherData)

    @Query("SELECT * FROM WeatherData")
    fun getWeatherData(): Flow<List<WeatherData>>

    @Query("SELECT * FROM WeatherData WHERE cityName =:cityName")
    suspend fun getSavedCity(cityName: String): WeatherData?
}

