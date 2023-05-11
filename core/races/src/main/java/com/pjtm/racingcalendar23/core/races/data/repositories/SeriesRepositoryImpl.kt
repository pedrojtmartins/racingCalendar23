package com.pjtm.racingcalendar23.core.races.data.repositories

import com.pjtm.racingcalendar23.core.cloudStore.data.CloudStore
import com.pjtm.racingcalendar23.core.common.di.IoDispatcher
import com.pjtm.racingcalendar23.core.database.data.daos.SeriesDao
import com.pjtm.racingcalendar23.core.races.data.mappers.toSeries
import com.pjtm.racingcalendar23.core.races.data.mappers.toSeriesDataEntity
import com.pjtm.racingcalendar23.core.races.domain.contracts.SeriesRepository
import com.pjtm.racingcalendar23.core.races.domain.entities.Series
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val seriesDao: SeriesDao,
    private val remoteDataSource: CloudStore,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SeriesRepository {
    override suspend fun getSeries(): Flow<List<Series>> = withContext(ioDispatcher) {
        seriesDao.getAll().map { series -> series.map { it.toSeries() } }
    }

    override suspend fun updateSeries(): Boolean = withContext(ioDispatcher) {
        val seriesData = remoteDataSource.getSeries().map { it.toSeriesDataEntity() }.toTypedArray()
        if (seriesData.isEmpty()) {
            return@withContext false
        }

        seriesDao.upsert(*seriesData)
        return@withContext true
    }
}