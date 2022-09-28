package com.laundry.di

import com.laundry.data.remote.repository.EntranceRepoImpl
import com.laundry.domain.EntranceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindEntranceUsecase(impl: EntranceRepoImpl): EntranceRepository

}