package com.tv.weatherapp

import app.cash.turbine.test
import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.domain.usecase.GetSavedCityUseCase
import com.tv.weatherapp.presentation.home.HomeState
import com.tv.weatherapp.presentation.home.HomeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    //mock dependencies
    private val getSavedCityUseCase :GetSavedCityUseCase = mockk()

    // the class test rule
    private lateinit var homeViewModel: HomeViewModel

    //coroutine test rule
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setup(){
        homeViewModel = HomeViewModel(getSavedCityUseCase)
    }

    @Test
    fun loadSavedCity() = runTest {
        val weatherData = WeatherData(
            "HYD",
            12.0,
            "Normal",
            "",
            21,
            22.0,
            22.0
        )
        coEvery { getSavedCityUseCase() }returns flowOf(weatherData)

        homeViewModel.state.test{
                assertEquals(HomeState(), awaitItem())
                homeViewModel.loadSavedCity()
               assertEquals(weatherData,awaitItem())

            cancelAndIgnoreRemainingEvents()
        }


    }

}