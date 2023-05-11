package com.pjtm.racingcalendar23.core.cloudStore.data

import com.google.firebase.storage.StorageReference
import com.pjtm.racingcalendar23.core.cloudStore.data.models.ConfigVersionCloudStoreDataEntity
import com.pjtm.racingcalendar23.core.cloudStore.data.models.RaceDataCloudStoreEntity
import com.pjtm.racingcalendar23.core.cloudStore.data.models.SeriesCloudStoreDataEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseCloudStore @Inject constructor(
    private val storageReference: StorageReference,
    private val moshi: Moshi
) : CloudStore {

    override suspend fun getConfigVersion(): ConfigVersionCloudStoreDataEntity { // return either
        val bytes = storageReference.child(CONFIG_VERSION_FILE)
            .getBytes(Long.MAX_VALUE)
            .await()

        if (bytes.isEmpty()) {
            return ConfigVersionCloudStoreDataEntity(0, 0)
        }

        val json = String(bytes)
        // TODO Add try catch
        return moshi.adapter(ConfigVersionCloudStoreDataEntity::class.java).fromJson(json)
            ?: ConfigVersionCloudStoreDataEntity(0, 0)
    }

    override suspend fun getRaces(): List<RaceDataCloudStoreEntity> {
        val bytes = storageReference.child(RACES_FILE)
            .getBytes(Long.MAX_VALUE)
            .await()

        if (bytes.isEmpty()) {
            return emptyList()
        }

        val json = String(bytes)
        val type = newParameterizedType(List::class.java, RaceDataCloudStoreEntity::class.java)
        return moshi.adapter<List<RaceDataCloudStoreEntity>>(type).fromJson(json) ?: emptyList()
    }

    override suspend fun getSeries(): List<SeriesCloudStoreDataEntity> {
        val bytes = storageReference.child(SERIES_FILE)
            .getBytes(Long.MAX_VALUE)
            .await()

        if (bytes.isEmpty()) {
            return emptyList()
        }

        val json = String(bytes)
        val type = newParameterizedType(List::class.java, SeriesCloudStoreDataEntity::class.java)
        return moshi.adapter<List<SeriesCloudStoreDataEntity>>(type).fromJson(json) ?: emptyList()
    }

    private companion object {
        const val CONFIG_VERSION_FILE = "versions.json"
        const val RACES_FILE = "races.json"
        const val SERIES_FILE = "series.json"
    }
}