package com.pjtm.racingcalendar23.data.repositories

import com.pjtm.racingcalendar23.data.database.daos.RacesDao
import com.pjtm.racingcalendar23.data.models.toRace
import com.pjtm.racingcalendar23.domain.contracts.RaceRepository
import com.pjtm.racingcalendar23.domain.entities.Race
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject

class RaceRepositoryImpl @Inject constructor(
    private val raceDao: RacesDao
) : RaceRepository {

    override suspend fun getRaces(startDate: Date?): Flow<List<Race>> =
        raceDao.getAll().map { races ->
            races.map { it.toRace() }
        }
}

