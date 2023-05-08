package com.pjtm.racingcalendar23.di

import android.content.Context
import androidx.room.Room
import com.pjtm.racingcalendar23.data.database.RacingCalendarDatabase
import com.pjtm.racingcalendar23.data.database.daos.RacesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

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
}