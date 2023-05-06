package com.pjtm.racingcalendar23.ui.home

import com.pjtm.racingcalendar23.domain.entities.Race

data class HomeUiState(
    val races: List<Race> = emptyList()
)
