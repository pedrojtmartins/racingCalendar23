package com.pjtm.racingcalendar23.domain.contracts

import com.pjtm.racingcalendar23.domain.entities.DataProperties


interface DataPropertiesRepository {
    suspend fun getProperties(): DataProperties
    suspend fun setProperties(properties: DataProperties)
}