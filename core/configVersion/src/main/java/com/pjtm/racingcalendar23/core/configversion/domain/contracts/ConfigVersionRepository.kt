package com.pjtm.racingcalendar23.core.configversion.domain.contracts

import com.pjtm.racingcalendar23.core.configversion.domain.entities.ConfigVersion

interface ConfigVersionRepository {
    suspend fun getCurrentConfig(): ConfigVersion
    suspend fun setCurrentConfig(config: ConfigVersion)

    suspend fun getLatestConfig(): ConfigVersion
}