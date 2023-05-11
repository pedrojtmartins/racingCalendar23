package com.pjtm.racingcalendar23.core.configversion.data.repositories

import com.pjtm.racingcalendar23.core.cloudStore.data.CloudStore
import com.pjtm.racingcalendar23.core.configversion.data.dataStore.ConfigVersionDataStore
import com.pjtm.racingcalendar23.core.configversion.data.mappers.toConfigVersion
import com.pjtm.racingcalendar23.core.configversion.domain.contracts.ConfigVersionRepository
import com.pjtm.racingcalendar23.core.configversion.domain.entities.ConfigVersion
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class ConfigVersionRepositoryImpl @Inject constructor(
    private val localDataSource: ConfigVersionDataStore,
    private val remoteDataSource: CloudStore
) : ConfigVersionRepository {

    override suspend fun getCurrentConfig(): ConfigVersion = with(localDataSource) {
        ConfigVersion(
            racesVersion = racesVersion.firstOrNull() ?: 0,
            seriesVersion = seriesVersion.firstOrNull() ?: 0
        )
    }

    override suspend fun setCurrentConfig(config: ConfigVersion) = with(localDataSource) {
        setRacesVersion(config.racesVersion)
        setSeriesVersion(config.seriesVersion)
    }

    override suspend fun getLatestConfig(): ConfigVersion =
        remoteDataSource.getConfigVersion().toConfigVersion()
}