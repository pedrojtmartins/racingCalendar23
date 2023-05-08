package com.pjtm.racingcalendar23.data.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pjtm.racingcalendar23.data.models.RaceDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RacesDao {
    @Query("SELECT * FROM race")
    suspend fun getAll(): Flow<List<RaceDataEntity>>

    @Upsert
    suspend fun upsert(vararg users: RaceDataEntity)
}

