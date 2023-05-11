package com.pjtm.racingcalendar23.core.database.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pjtm.racingcalendar23.core.database.data.models.SeriesDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SeriesDao {
    @Query("SELECT * FROM series")
    fun getAll(): Flow<List<SeriesDataEntity>>

    @Upsert
    suspend fun upsert(vararg users: SeriesDataEntity)
}

