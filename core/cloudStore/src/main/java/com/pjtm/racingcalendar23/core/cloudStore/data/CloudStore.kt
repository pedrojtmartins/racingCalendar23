package com.pjtm.racingcalendar23.core.cloudStore.data

import com.pjtm.racingcalendar23.core.cloudStore.data.models.ConfigVersionCloudStoreDataEntity
import com.pjtm.racingcalendar23.core.cloudStore.data.models.RaceDataCloudStoreEntity
import com.pjtm.racingcalendar23.core.cloudStore.data.models.SeriesCloudStoreDataEntity


interface CloudStore {

    suspend fun getConfigVersion(): ConfigVersionCloudStoreDataEntity
    suspend fun getRaces(): List<RaceDataCloudStoreEntity>
    suspend fun getSeries(): List<SeriesCloudStoreDataEntity>
}
