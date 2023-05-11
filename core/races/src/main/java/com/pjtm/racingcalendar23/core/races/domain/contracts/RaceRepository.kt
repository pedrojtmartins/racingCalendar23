package com.pjtm.racingcalendar23.core.races.domain.contracts

import com.pjtm.racingcalendar23.core.races.domain.entities.Race
import com.pjtm.racingcalendar23.core.races.domain.entities.Series
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface RaceRepository {
    suspend fun getRaces(startDate: Date): Flow<List<Race>>
    suspend fun getRacesForSeries(startDate: Date, seriesIds: List<Int>): Flow<List<Race>>

    suspend fun updateRaces(): Boolean
    suspend fun getSeries(): Flow<List<Series>>
}