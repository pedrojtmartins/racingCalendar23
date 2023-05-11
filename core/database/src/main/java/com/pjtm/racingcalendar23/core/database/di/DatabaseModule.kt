package com.pjtm.racingcalendar23.core.database.di

import android.content.Context
import androidx.room.Room
import com.pjtm.racingcalendar23.core.database.data.daos.RacesDao
import com.pjtm.racingcalendar23.core.database.data.daos.SeriesDao
import com.pjtm.racingcalendar23.core.database.data.db.RacingCalendarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext applicationContext: Context
    ): RacingCalendarDatabase = Room.databaseBuilder(
        applicationContext,
        RacingCalendarDatabase::class.java,
        RacingCalendarDatabase.name
    ).build()

    @Provides
    fun providesRacesDao(db: RacingCalendarDatabase): RacesDao = db.racesDao()

    @Provides
    fun providesSeriesDao(db: RacingCalendarDatabase): SeriesDao = db.seriesDao()
}