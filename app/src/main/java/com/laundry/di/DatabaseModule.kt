package com.laundry.di

import android.content.Context
import androidx.room.Room
import com.laundry.data.database.CategoryDatabase
import com.laundry.data.database.dao.CategoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): CategoryDatabase {
        return Room.databaseBuilder(appContext, CategoryDatabase::class.java, "main_order")
            .build()
    }

    @Provides
    fun provideWorkoutDao(database: CategoryDatabase): CategoryDao = database.getCategoryDao()
}