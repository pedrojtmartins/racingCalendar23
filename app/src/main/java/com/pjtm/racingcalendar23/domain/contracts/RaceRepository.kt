package com.pjtm.racingcalendar23.domain.contracts

import com.pjtm.racingcalendar23.domain.entities.Race
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface RaceRepository {
    suspend fun getRaces(startDate: Date? = null): Flow<List<Race>>
}