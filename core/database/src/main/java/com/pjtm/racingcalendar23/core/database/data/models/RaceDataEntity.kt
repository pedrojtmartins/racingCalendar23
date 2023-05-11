package com.pjtm.racingcalendar23.core.database.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "races")
data class RaceDataEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "seriesId") val seriesId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String
)
