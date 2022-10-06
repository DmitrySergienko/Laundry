package com.laundry.di

import com.laundry.data.remote.repository.*
import com.laundry.domain.*
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

    @Binds
    @Singleton
    abstract fun bindSignupUsecase(impl: SignupRepoImpl): SignupRepository

    @Binds
    @Singleton
    abstract fun bindCategoryUsecase(impl: CategoryRepoImpl): CategoryRepository

    @Binds
    @Singleton
    abstract fun bindSaveOrderUseCase(impl: SaveOrderRepoImpl): SaveOrderRepository

    @Binds
    @Singleton
    abstract fun bindOrderHistoryUsecase(impl: OrderHistoryRepoImpl): OrderHistoryRepository

}