package com.tv.weatherapp.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tv.weatherapp.domain.usecase.GetCityWeatherUseCase
import com.tv.weatherapp.domain.usecase.GetSavedCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSavedCityUseCase: GetSavedCityUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    init {
        loadSavedCity()
    }

    fun loadSavedCity() {
        viewModelScope.launch {
            getSavedCityUseCase().collect { weatherData ->
                if (weatherData != null) {
                    _state.value = state.value.copy(weatherData = weatherData)
                } else {
                    _state.value = state.value.copy(
                        error = "No city saved. Please search for one."
                    )
                }
            }
        }
    }

}