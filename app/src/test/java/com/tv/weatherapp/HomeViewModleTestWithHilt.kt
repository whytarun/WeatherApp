package com.tv.weatherapp

import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.domain.usecase.GetSavedCityUseCase
import com.tv.weatherapp.presentation.home.HomeState
import com.tv.weatherapp.presentation.home.HomeViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.coEvery
import io.mockk.every
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class HomeViewModleTestWithHilt {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val mainDispatcherRule =MainDispatcherRule()

    @Inject
    lateinit var getSavedCityUseCase: GetSavedCityUseCase

    lateinit var homeViewModel: HomeViewModel
    @Before
    fun setup(){
        hiltRule.inject()
        coEvery { getSavedCityUseCase() } returns flowOf(
            WeatherData(
                cityName = "HYD",
                temperature = 12.0,
                weatherCondition = "Normal",
                weatherIcon = "",
                humidity = 21,
                uvIndex = 22.0,
                feelsLike = 22.0
            )
        )
        homeViewModel = HomeViewModel(getSavedCityUseCase)

    }

    @Test
    fun loadSaveCity() = runTest {



        homeViewModel.loadSavedCity()

        // Assert state
        val expectedState = HomeState(
            weatherData = WeatherData(
                cityName = "HYD",
                temperature = 12.0,
                weatherCondition = "Normal",
                weatherIcon = "",
                humidity = 21,
                uvIndex = 22.0,
                feelsLike = 22.0
            ),
            isLoading = false,
            error = null
        )

        assertEquals(expectedState, homeViewModel.state.value)
    }




}