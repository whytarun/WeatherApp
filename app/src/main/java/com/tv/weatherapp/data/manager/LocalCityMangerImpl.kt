package com.tv.weatherapp.data.manager

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.squareup.moshi.Moshi
import com.tv.weatherapp.domain.manager.LocalCityManager
import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.util.Constants
import com.tv.weatherapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalCityMangerImpl @Inject constructor(
    private val application: Application,
    private val moshi: Moshi
) :LocalCityManager{

    private val weatherDataAdapter = moshi.adapter(WeatherData::class.java)

    override suspend fun saveSelectedCity(weatherData: WeatherData) {
        val jsonData = weatherDataAdapter.toJson(weatherData)
        application.dataStore.edit { preferences ->
            preferences[PreferenceKeys.SELECTED_CITY] = jsonData
        }
    }

    override suspend fun getSavedCity(): Flow<WeatherData?> {
        return application.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.SELECTED_CITY]?.let {
                weatherDataAdapter.fromJson(it)
            }
        }
    }
}

private val readOnlyProperty = preferencesDataStore(name = USER_SETTINGS)

val Context.dataStore: DataStore<Preferences> by readOnlyProperty

private object PreferenceKeys {
    val SELECTED_CITY = stringPreferencesKey(Constants.SELECTED_CITY)
}

