package com.tv.weatherapp.presentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()

    object SearchWeatherData : SearchEvent()
    object saveSelectedCity : SearchEvent()
}