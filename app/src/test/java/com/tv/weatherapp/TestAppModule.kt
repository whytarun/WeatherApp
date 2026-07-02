package com.tv.weatherapp

import com.tv.weatherapp.domain.usecase.GetSavedCityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.mockk.mockk


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    fun provideGetSaveCityUseCase(): GetSavedCityUseCase{
        return mockk()
    }
}