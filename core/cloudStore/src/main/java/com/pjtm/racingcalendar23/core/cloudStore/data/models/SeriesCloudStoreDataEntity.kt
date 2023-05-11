package com.pjtm.racingcalendar23.core.cloudStore.data.models

import com.squareup.moshi.Json

data class SeriesCloudStoreDataEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String
)