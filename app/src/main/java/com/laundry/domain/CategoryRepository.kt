package com.laundry.domain

import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.CategoryResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CategoryRepository {

    suspend fun getCategory(): Flow<DataState<CategoryResponse>>
}