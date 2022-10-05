package com.laundry.di

import android.content.Context
import com.laundry.data.repository.datastore.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun bindDataStoreRepository(context: Context) = DataStoreRepository(context)

}