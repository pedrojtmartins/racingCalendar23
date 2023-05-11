package com.pjtm.racingcalendar23.core.races.domain.entities

import java.time.ZonedDateTime

data class Race(
    val id: Int,
    val seriesId: Int,
    val name: String,
    val dateTime: ZonedDateTime,
)
