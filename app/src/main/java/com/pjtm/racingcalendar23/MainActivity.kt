package com.pjtm.racingcalendar23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pjtm.racingcalendar23.ui.theme.RacingCalendar23Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RacingCalendar23Theme {}
        }
    }
}