package com.pjtm.racingcalendar23.core.database.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "series")
data class SeriesDataEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String
)