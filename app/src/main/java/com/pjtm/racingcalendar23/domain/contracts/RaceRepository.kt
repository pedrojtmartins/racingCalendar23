package com.pjtm.racingcalendar23.domain.contracts

import com.pjtm.racingcalendar23.domain.entities.Race
import java.util.Date

interface RaceRepository {
    suspend fun getRaces(startDate: Date? = null): List<Race>
}