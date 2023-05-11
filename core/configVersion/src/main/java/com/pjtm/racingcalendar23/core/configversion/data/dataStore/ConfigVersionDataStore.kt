package com.pjtm.racingcalendar23.core.configversion.data.dataStore

import kotlinx.coroutines.flow.Flow

interface ConfigVersionDataStore {

    val racesVersion: Flow<Int>
    suspend fun setRacesVersion(version: Int)

    val seriesVersion: Flow<Int>
    suspend fun setSeriesVersion(version: Int)

    val latestUpdateCheck: Flow<String>
    suspend fun setLatestUpdateCheck(date: String)
}
