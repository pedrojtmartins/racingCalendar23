package com.pjtm.racingcalendar23.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pjtm.racingcalendar23.domain.entities.Race
import com.pjtm.racingcalendar23.ui.theme.RacingCalendar23Theme

@Composable
fun HomeScreen(
    onCardClick: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(uiState, onCardClick)
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onCardClick: (Int) -> Unit
) {
    RacingCalendar23Theme {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            items(items = uiState.races) {
                RaceCard(
                    race = it,
                    onCardClick = onCardClick
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RaceCard(race: Race, onCardClick: (Int) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onCardClick(race.id) }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Text(
                modifier = Modifier.weight(1F),
                text = race.name
            )
            Text(
                text = race.date
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        uiState = HomeUiState(
            races = listOf(
                Race(0, "R1", "d1"),
                Race(1, "R2", "d2"),
                Race(2, "R3", "d3")
            )
        ),
        onCardClick = {}
    )
}