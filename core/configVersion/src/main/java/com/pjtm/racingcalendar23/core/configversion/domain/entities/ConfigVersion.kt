package com.pjtm.racingcalendar23.core.configversion.domain.entities

data class ConfigVersion(
    val racesVersion: Int,
    val seriesVersion: Int
) {
    fun isNewerThan(other: ConfigVersion): Boolean =
        racesVersion > other.racesVersion || seriesVersion > other.seriesVersion
}
