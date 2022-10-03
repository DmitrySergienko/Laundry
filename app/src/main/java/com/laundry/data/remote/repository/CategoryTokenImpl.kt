package com.laundry.data.remote.repository

import com.laundry.data.remote.api.CategoryApi
import com.laundry.data.utils.DataState
import com.laundry.domain.CategoryRepository
import com.laundry.domain.entity.remote.CategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CategoryTokenImpl @Inject constructor(
    private val api: CategoryApi
): CategoryRepository {

    override suspend fun getCategory(): Flow<DataState<CategoryResponse>> =

        flow {
            val response = api.getCategoryList()
            emit(DataState.Success(response))
        }.flowOn(Dispatchers.IO)

}