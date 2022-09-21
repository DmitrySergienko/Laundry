package com.laundry.domain.usecases

import com.laundry.domain.Category
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {

    fun getCategoryList(): Flow<List<Category>>
}