package com.pjtm.racingcalendar23.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PropertiesDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATA_STORE_NAME)

    val racesVersion: Flow<Int> = context.dataStore.data.map { it[RACES_VERSION] ?: -1 }
    suspend fun setRacesVersion(version: Int) {
        context.dataStore.edit { it[RACES_VERSION] = version }
    }

    val seriesVersion: Flow<Int> = context.dataStore.data.map { it[SERIES_VERSION] ?: -1 }
    suspend fun setSeriesVersion(version: Int) {
        context.dataStore.edit { it[SERIES_VERSION] = version }
    }

    companion object {
        private const val DATA_STORE_NAME = "properties"
        private val RACES_VERSION = intPreferencesKey("races_version")
        private val SERIES_VERSION = intPreferencesKey("series_version")
    }
}

