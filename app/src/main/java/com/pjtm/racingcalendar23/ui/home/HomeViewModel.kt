package com.pjtm.racingcalendar23.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pjtm.racingcalendar23.core.races.domain.useCases.GetRacesUseCase
import com.pjtm.racingcalendar23.domain.useCases.UpdateDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getRaces: GetRacesUseCase,
    updateData: UpdateDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            launch { updateData() }
            launch {
                getRaces().collect { races ->
                    _uiState.update {
                        it.copy(races = races)
                    }
                }
            }
        }
    }
}