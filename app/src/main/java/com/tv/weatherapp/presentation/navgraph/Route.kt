package com.tv.weatherapp.presentation.navgraph

sealed class Route(
    val route: String,
) {
    data object HomeScreen : Route(route = "HomeScreen")

    data object SearchScreen : Route(route = "SearchScreen")
}