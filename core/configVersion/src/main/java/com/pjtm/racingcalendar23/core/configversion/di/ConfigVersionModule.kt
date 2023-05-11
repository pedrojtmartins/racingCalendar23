package com.pjtm.racingcalendar23.core.configversion.di

import com.pjtm.racingcalendar23.core.configversion.data.dataStore.ConfigVersionDataStore
import com.pjtm.racingcalendar23.core.configversion.data.dataStore.ConfigVersionDataStoreImpl
import com.pjtm.racingcalendar23.core.configversion.data.repositories.ConfigVersionRepositoryImpl
import com.pjtm.racingcalendar23.core.configversion.domain.contracts.ConfigVersionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ConfigVersionModule {

    @Binds
    @Singleton
    abstract fun bindsDataProperties(
        actual: ConfigVersionRepositoryImpl
    ): ConfigVersionRepository

    @Binds
    @Singleton
    abstract fun bindsDataStore(
        actual: ConfigVersionDataStoreImpl
    ): ConfigVersionDataStore
}