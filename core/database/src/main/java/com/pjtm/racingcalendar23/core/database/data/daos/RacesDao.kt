package com.pjtm.racingcalendar23.core.database.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pjtm.racingcalendar23.core.database.data.models.RaceDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RacesDao {
    @Query("SELECT * FROM races")
    fun getAll(): Flow<List<RaceDataEntity>>

    @Query("SELECT * FROM races WHERE seriesId IN (:seriesIds)")
    fun getAllForSeries(seriesIds: List<Int>): Flow<List<RaceDataEntity>>

    @Upsert
    suspend fun upsert(vararg users: RaceDataEntity)
}

