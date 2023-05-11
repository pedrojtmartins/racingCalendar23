package com.pjtm.racingcalendar23.core.races.domain.useCases

import com.pjtm.racingcalendar23.core.races.domain.contracts.RaceRepository
import com.pjtm.racingcalendar23.core.races.domain.entities.Race
import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class GetRacesUseCase @Inject constructor(
    private val repository: RaceRepository
) {
    suspend operator fun invoke(
        startDate: Date = Calendar.getInstance().time
    ): Flow<List<Race>> = repository.getRaces(startDate = startDate)
}