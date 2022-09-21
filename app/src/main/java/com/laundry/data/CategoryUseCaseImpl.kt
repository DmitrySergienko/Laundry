package com.laundry.data

import com.laundry.data.database.dao.CategoryDao
import com.laundry.domain.Category
import com.laundry.domain.usecases.CategoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryUseCaseImpl @Inject constructor(
    private val categotyDao: CategoryDao
): CategoryUseCase {
    override fun getCategoryList(): Flow<List<Category>> {
        TODO("Not yet implemented")
//        return categotyDao.getAll().map {
//            it.map { categoryEntity -> Category() }
//        }
    }


}