package com.tv.weatherapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.presentation.Dimens.MediumPadding1
import com.tv.weatherapp.presentation.common.SearchBar
import com.tv.weatherapp.presentation.search.components.SearchResultCard

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    onCitySelected: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumPadding1)
            .statusBarsPadding()
    ) {

        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchWeatherData) }
        )

        Spacer(modifier = Modifier.height(MediumPadding1))


        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            state.error != null -> {
                Text(
                    text = "Error: ${state.error}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            state.weatherData != null -> {
                SearchResultCard(
                    weatherData = state.weatherData,
                    onClick = {
                        event(SearchEvent.saveSelectedCity)
                        onCitySelected()
                    }
                )
            }
            else -> {
                Text(
                    text = "Search for a city to see the results.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
