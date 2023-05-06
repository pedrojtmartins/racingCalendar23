package com.pjtm.racingcalendar23.domain.useCases

import com.pjtm.racingcalendar23.domain.contracts.RaceRepository
import com.pjtm.racingcalendar23.domain.entities.Race
import java.util.Calendar
import javax.inject.Inject

class GetUpcomingRacesUseCase @Inject constructor(
    private val repository: RaceRepository
) {
    suspend operator fun invoke(): List<Race> =
        repository.getRaces(startDate = Calendar.getInstance().time)
}