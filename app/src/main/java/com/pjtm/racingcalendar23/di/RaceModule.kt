package com.pjtm.racingcalendar23.di

import com.pjtm.racingcalendar23.data.repositories.RaceRepositoryImpl
import com.pjtm.racingcalendar23.domain.contracts.RaceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RaceModule {

    @Binds
    abstract fun bindsRaceRepository(
        actual: RaceRepositoryImpl
    ): RaceRepository
}