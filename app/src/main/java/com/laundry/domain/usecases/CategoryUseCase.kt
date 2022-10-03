package com.laundry.domain.usecases

import com.laundry.data.utils.DataState
import com.laundry.data.utils.NetworkHelper
import com.laundry.domain.CategoryRepository
import com.laundry.domain.entity.remote.CategoryResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository

) : NetworkHelper<CategoryUseCase.Params, CategoryResponse>() {

    class Params( val request: CategoryResponse)

    override suspend fun buildUseCase(parameter: CategoryUseCase.Params): Flow<DataState<CategoryResponse>> {
        return categoryRepository.getCategory()
    }


}