package com.tv.weatherapp.di


import com.tv.weatherapp.data.manager.LocalCityMangerImpl
import com.tv.weatherapp.domain.manager.LocalCityManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MangerModule {

    @Binds
    @Singleton
    abstract fun bindLocalUserManger(localCityMangerImpl: LocalCityMangerImpl) : LocalCityManager
}