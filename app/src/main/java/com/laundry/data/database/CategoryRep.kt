package com.laundry.data.database

import androidx.lifecycle.LiveData
import com.laundry.data.database.dao.CategoryDao
import com.laundry.data.database.entities.CategoryEntity

class CategoryRep(
    private val categoryDao: CategoryDao
) {
    val readAllData: LiveData<List<CategoryEntity>> = categoryDao.readAll()

    suspend fun addCategory(category: CategoryEntity){
        categoryDao.addCategory(category)
    }

}