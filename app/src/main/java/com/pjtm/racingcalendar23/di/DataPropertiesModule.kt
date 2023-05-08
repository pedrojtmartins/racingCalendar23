package com.pjtm.racingcalendar23.di

import com.pjtm.racingcalendar23.data.repositories.DataPropertiesRepositoryImpl
import com.pjtm.racingcalendar23.domain.contracts.DataPropertiesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataPropertiesModule {

    @Binds
    abstract fun bindsDataProperties(
        actual: DataPropertiesRepositoryImpl
    ): DataPropertiesRepository
}