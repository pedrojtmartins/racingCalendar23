package com.pjtm.racingcalendar23.core.races.data.mappers

import com.pjtm.racingcalendar23.core.cloudStore.data.models.RaceDataCloudStoreEntity
import com.pjtm.racingcalendar23.core.database.data.models.RaceDataEntity
import com.pjtm.racingcalendar23.core.races.domain.entities.Race
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter.ISO_DATE_TIME

fun RaceDataEntity.toRace(): Race {
    val zonedDateTime = ZonedDateTime.parse(date, ISO_DATE_TIME)
        .withZoneSameInstant(ZoneId.systemDefault())

    return Race(
        id = id,
        name = name,
        dateTime = zonedDateTime,
        seriesId = seriesId
    )
}

fun RaceDataCloudStoreEntity.toRaceDataEntity() = RaceDataEntity(
    id = id,
    seriesId = seriesId,
    name = name,
    date = date
)