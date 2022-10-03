package com.laundry.di

import com.laundry.data.remote.repository.CategoryRepoImpl
import com.laundry.data.remote.repository.EntranceRepoImpl
import com.laundry.data.remote.repository.SignupRepoImpl
import com.laundry.data.repository.datastore.DataStoreRepository
import com.laundry.domain.CategoryRepository
import com.laundry.domain.EntranceRepository
import com.laundry.domain.SignupRepository
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
    abstract fun bindDataStoreRepository(impl: DataStoreRepository): DataStoreRepository


}