package com.pjtm.racingcalendar23.core.races.data.repositories

import com.pjtm.racingcalendar23.core.cloudStore.data.CloudStore
import com.pjtm.racingcalendar23.core.common.di.IoDispatcher
import com.pjtm.racingcalendar23.core.database.data.daos.RacesDao
import com.pjtm.racingcalendar23.core.database.data.daos.SeriesDao
import com.pjtm.racingcalendar23.core.races.data.mappers.toRace
import com.pjtm.racingcalendar23.core.races.data.mappers.toRaceDataEntity
import com.pjtm.racingcalendar23.core.races.data.mappers.toSeries
import com.pjtm.racingcalendar23.core.races.domain.contracts.RaceRepository
import com.pjtm.racingcalendar23.core.races.domain.entities.Race
import com.pjtm.racingcalendar23.core.races.domain.entities.Series
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject

class RaceRepositoryImpl @Inject constructor(
    private val raceDao: RacesDao,
    private val seriesDao: SeriesDao,
    private val remoteDataSource: CloudStore,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RaceRepository {

    override suspend fun getRaces(startDate: Date): Flow<List<Race>> = withContext(ioDispatcher) {
        raceDao.getAll().map { races ->
            races.map { it.toRace() }
        }
    }

    override suspend fun getRacesForSeries(
        startDate: Date,
        seriesIds: List<Int>
    ): Flow<List<Race>> = withContext(ioDispatcher) {
        raceDao.getAllForSeries(seriesIds).map { races ->
            races.map { it.toRace() }
        }
    }

    override suspend fun updateRaces(): Boolean = withContext(ioDispatcher) {
        val raceData = remoteDataSource.getRaces().map { it.toRaceDataEntity() }.toTypedArray()
        if (raceData.isEmpty()) {
            return@withContext false
        }

        raceDao.upsert(*raceData)
        return@withContext true
    }

    override suspend fun getSeries(): Flow<List<Series>> = withContext(ioDispatcher) {
        seriesDao.getAll().map { series ->
            series.map { it.toSeries() }
        }
    }
}
