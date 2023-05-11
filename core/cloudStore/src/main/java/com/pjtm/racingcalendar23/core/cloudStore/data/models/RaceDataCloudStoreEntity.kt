package com.pjtm.racingcalendar23.core.cloudStore.data.models

import com.squareup.moshi.Json

data class RaceDataCloudStoreEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "seriesId") val seriesId: Int,
    @Json(name = "name") val name: String,
    @Json(name = "date") val date: String
)
