package com.tv.weatherapp.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.domain.usecase.GetCityWeatherUseCase
import com.tv.weatherapp.domain.usecase.SaveSelectedCityUseCase
import com.tv.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getCityWeatherUseCase: GetCityWeatherUseCase,
    private val saveSelectedCityUseCase: SaveSelectedCityUseCase
) :ViewModel(){

     var state by mutableStateOf(SearchState())
         private set

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                state = state.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchWeatherData -> {
                loadWeather()
            }

            is SearchEvent.saveSelectedCity -> {
                state.weatherData?.let { saveSelectedCity(it) }
            }
        }
    }

    fun loadWeather() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            when (val result = getCityWeatherUseCase(state.searchQuery)) {
                is Resource.Success -> {
                    state = state.copy(weatherData = result.data, isLoading = false)
                }
                is Resource.Error -> {
                    state = state.copy(error = result.message, isLoading = false)
                }
            }
        }
    }

    fun saveSelectedCity(weatherData: WeatherData){
        viewModelScope.launch {
            saveSelectedCityUseCase.invoke(weatherData = weatherData)
        }
    }
}