package com.pjtm.racingcalendar23.core.races.di

import com.pjtm.racingcalendar23.core.races.data.repositories.RaceRepositoryImpl
import com.pjtm.racingcalendar23.core.races.data.repositories.SeriesRepositoryImpl
import com.pjtm.racingcalendar23.core.races.domain.contracts.RaceRepository
import com.pjtm.racingcalendar23.core.races.domain.contracts.SeriesRepository
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

    @Binds
    abstract fun bindsSeriesRepository(
        actual: SeriesRepositoryImpl
    ): SeriesRepository
}