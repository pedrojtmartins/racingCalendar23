package com.pjtm.racingcalendar23.ui.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val homeScreenRoute = "home"

fun NavGraphBuilder.homeScreen() {
    composable(route = homeScreenRoute) {
        HomeScreen(onCardClick = {})
    }
}
