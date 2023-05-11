package com.pjtm.racingcalendar23.core.cloudStore.data.models

import com.squareup.moshi.Json

data class ConfigVersionCloudStoreDataEntity(
    @Json(name = "seriesVersion") val seriesVersion: Int,
    @Json(name = "racesVersion") val racesVersion: Int
)