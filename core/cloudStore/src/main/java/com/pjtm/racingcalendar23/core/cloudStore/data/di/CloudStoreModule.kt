package com.pjtm.racingcalendar23.core.cloudStore.data.di

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.pjtm.racingcalendar23.core.cloudStore.data.CloudStore
import com.pjtm.racingcalendar23.core.cloudStore.data.FirebaseCloudStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CloudStoreModule {

    @Provides
    @Singleton
    fun providesCloudStore(
        actual: FirebaseCloudStore
    ): CloudStore = actual


    @Provides
    @Singleton
    fun providesFirebaseStorageReference(): StorageReference =
        FirebaseStorage.getInstance().reference.child("stg")
}


