package com.pjtm.racingcalendar23.data.repositories

import com.pjtm.racingcalendar23.data.dataStore.PropertiesDataStore
import com.pjtm.racingcalendar23.domain.contracts.DataPropertiesRepository
import com.pjtm.racingcalendar23.domain.entities.DataProperties
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class DataPropertiesRepositoryImpl @Inject constructor(
    private val dataSource: PropertiesDataStore
) : DataPropertiesRepository {

    override suspend fun getProperties(): DataProperties = with(dataSource) {
        DataProperties(
            racesVersion = racesVersion.firstOrNull() ?: -1,
            seriesVersion = seriesVersion.firstOrNull() ?: -1
        )
    }

    override suspend fun setProperties(properties: DataProperties) = with(dataSource) {
        setRacesVersion(properties.racesVersion)
        setSeriesVersion(properties.seriesVersion)
    }
}