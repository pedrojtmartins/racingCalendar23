package com.pjtm.racingcalendar23.data.repositories

import com.pjtm.racingcalendar23.domain.contracts.RaceRepository
import com.pjtm.racingcalendar23.domain.entities.Race
import java.util.Date
import javax.inject.Inject

class RaceRepositoryImpl @Inject constructor() : RaceRepository {
    override suspend fun getRaces(startDate: Date?): List<Race> {
        return listOf(
            Race(0, "R1", "d1"),
            Race(1, "R2", "d2"),
            Race(2, "R3", "d3")
        )
    }
}