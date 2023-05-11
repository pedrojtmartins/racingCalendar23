package com.pjtm.racingcalendar23.domain.useCases

import com.pjtm.racingcalendar23.core.configversion.domain.contracts.ConfigVersionRepository
import com.pjtm.racingcalendar23.core.races.domain.contracts.RaceRepository
import com.pjtm.racingcalendar23.core.races.domain.contracts.SeriesRepository
import com.pjtm.racingcalendar23.domain.useCases.UpdateResult.FAILED
import com.pjtm.racingcalendar23.domain.useCases.UpdateResult.NO_UPDATE
import com.pjtm.racingcalendar23.domain.useCases.UpdateResult.UPDATED
import javax.inject.Inject

enum class UpdateResult {
    NO_UPDATE,
    UPDATED,
    FAILED
}

class UpdateDataUseCase @Inject constructor(
    private val configVersionRepository: ConfigVersionRepository,
    private val raceRepository: RaceRepository,
    private val seriesRepository: SeriesRepository
) {

    suspend operator fun invoke(): UpdateResult {
        val latestConfig = configVersionRepository.getLatestConfig()
        val currentConfig = configVersionRepository.getCurrentConfig()

        if (!latestConfig.isNewerThan(currentConfig)) {
            return NO_UPDATE
        }

        val racesUpdated = raceRepository.updateRaces()
        val seriesUpdated = seriesRepository.updateSeries()
        if (!racesUpdated || !seriesUpdated) {
            return FAILED
        }

        configVersionRepository.setCurrentConfig(latestConfig)
        return UPDATED
    }
}

