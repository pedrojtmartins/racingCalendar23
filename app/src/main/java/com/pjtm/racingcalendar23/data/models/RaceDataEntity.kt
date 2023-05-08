package com.pjtm.racingcalendar23.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pjtm.racingcalendar23.domain.entities.Race

@Entity(tableName = "race")
data class RaceDataEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String
)


fun RaceDataEntity.toRace() = Race(
    uid = uid,
    name = name,
    date = date
)

fun Race.toRaceDataEntity() = RaceDataEntity(
    uid = uid,
    name = name,
    date = date
)