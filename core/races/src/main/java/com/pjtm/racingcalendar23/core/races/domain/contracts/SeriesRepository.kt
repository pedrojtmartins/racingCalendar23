package com.pjtm.racingcalendar23.core.races.domain.contracts

import com.pjtm.racingcalendar23.core.races.domain.entities.Series
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {
    suspend fun getSeries(): Flow<List<Series>>
    suspend fun updateSeries(): Boolean
}