package com.laundry.di

import com.laundry.data.remote.repository.EntranceUsecaseImpl
import com.laundry.domain.usecases.EntranceUsecase
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
    abstract fun bindEntranceUsecase(impl: EntranceUsecaseImpl): EntranceUsecase

}