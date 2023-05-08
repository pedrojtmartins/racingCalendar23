package com.pjtm.racingcalendar23.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pjtm.racingcalendar23.data.database.daos.RacesDao
import com.pjtm.racingcalendar23.data.models.RaceDataEntity


@Database(entities = [RaceDataEntity::class], version = 1)
abstract class RacingCalendarDatabase : RoomDatabase() {

    abstract fun racesDao(): RacesDao

    companion object {
        const val name = "racingCalendarDatabase"
    }
}
