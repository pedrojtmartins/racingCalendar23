package com.pjtm.racingcalendar23.core.database.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pjtm.racingcalendar23.core.database.data.daos.RacesDao
import com.pjtm.racingcalendar23.core.database.data.daos.SeriesDao
import com.pjtm.racingcalendar23.core.database.data.models.RaceDataEntity
import com.pjtm.racingcalendar23.core.database.data.models.SeriesDataEntity

@Database(
    version = 1,
    entities = [
        RaceDataEntity::class,
        SeriesDataEntity::class
    ]
)
abstract class RacingCalendarDatabase : RoomDatabase() {

    abstract fun racesDao(): RacesDao
    abstract fun seriesDao(): SeriesDao

    companion object {
        const val name = "racingCalendarDatabase"
    }
}
