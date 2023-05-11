package com.pjtm.racingcalendar23.core.configversion.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ConfigVersionDataStoreImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ConfigVersionDataStore {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATA_STORE_NAME)

    override val racesVersion: Flow<Int> =
        context.dataStore.data.map { it[RACES_VERSION] ?: 0 }

    override suspend fun setRacesVersion(version: Int) {
        context.dataStore.edit { it[RACES_VERSION] = version }
    }

    override val seriesVersion: Flow<Int> =
        context.dataStore.data.map { it[SERIES_VERSION] ?: 0 }

    override suspend fun setSeriesVersion(version: Int) {
        context.dataStore.edit { it[SERIES_VERSION] = version }
    }

    override val latestUpdateCheck: Flow<String> =
        context.dataStore.data.map { it[LATEST_UPDATE_CHECK] ?: "" }

    override suspend fun setLatestUpdateCheck(date: String) {
        context.dataStore.edit { it[LATEST_UPDATE_CHECK] = date }
    }

    companion object {
        private const val DATA_STORE_NAME = "configVersion"
        private val RACES_VERSION = intPreferencesKey("races_version")
        private val SERIES_VERSION = intPreferencesKey("series_version")
        private val LATEST_UPDATE_CHECK = stringPreferencesKey("latest_update_check")
    }
}

