package com.pjtm.racingcalendar23.core.configversion.data.mappers

import com.pjtm.racingcalendar23.core.cloudStore.data.models.ConfigVersionCloudStoreDataEntity
import com.pjtm.racingcalendar23.core.configversion.domain.entities.ConfigVersion

fun ConfigVersionCloudStoreDataEntity.toConfigVersion() = ConfigVersion(
    racesVersion = racesVersion,
    seriesVersion = seriesVersion
)