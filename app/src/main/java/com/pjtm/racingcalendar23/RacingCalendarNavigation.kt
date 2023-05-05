package com.pjtm.racingcalendar23

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.pjtm.racingcalendar23.ui.home.homeScreen
import com.pjtm.racingcalendar23.ui.home.homeScreenRoute

@Composable
fun racingCalendarNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = homeScreenRoute) {
        homeScreen()
    }

}