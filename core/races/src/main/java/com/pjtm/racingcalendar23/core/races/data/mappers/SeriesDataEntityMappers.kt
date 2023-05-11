package com.pjtm.racingcalendar23.core.races.data.mappers

import com.pjtm.racingcalendar23.core.cloudStore.data.models.SeriesCloudStoreDataEntity
import com.pjtm.racingcalendar23.core.database.data.models.SeriesDataEntity
import com.pjtm.racingcalendar23.core.races.domain.entities.Series

fun SeriesDataEntity.toSeries() = Series(
    id = id,
    name = name,
)

fun SeriesCloudStoreDataEntity.toSeriesDataEntity() = SeriesDataEntity(
    id = id,
    name = name
)