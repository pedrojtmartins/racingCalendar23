package com.pjtm.racingcalendar23.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pjtm.racingcalendar23.ui.theme.RacingCalendar23Theme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(uiState)
}

@Composable
fun HomeScreen(
    uiState: HomeUiState
) {
    RacingCalendar23Theme {
        Text(text = "Hello World")
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(HomeUiState())
}