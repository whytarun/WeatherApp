package com.tv.weatherapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tv.weatherapp.presentation.Dimens.MediumPadding1
import com.tv.weatherapp.presentation.Dimens.MediumPadding2
import com.tv.weatherapp.presentation.common.SearchBar
import com.tv.weatherapp.presentation.home.components.NoCitySelectedContent
import com.tv.weatherapp.presentation.home.components.WeatherContent


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToSearch : () -> Unit
) {
    Column {
        val state by viewModel.state.collectAsState()
        LaunchedEffect(key1 = state.weatherData) {
            if (state.weatherData == null) {
                viewModel.loadSavedCity()
            }
        }
        SearchBar(
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .padding(top = MediumPadding2)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = { },
            onClick = navigateToSearch
        )

        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            state.error != null -> {
                NoCitySelectedContent()
            }

            state.weatherData != null -> {
                val cityWeatherData = state.weatherData
                cityWeatherData?.let {
                    WeatherContent(
                        weatherData = cityWeatherData
                    )
                }
            }
        }
    }
}