package com.laundry.data.database.dao

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.laundry.data.database.CategoryDatabase
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.domain.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(category: CategoryEntity)

    @Query("SELECT * FROM category_database ORDER BY id ASC")
    fun readAll(): LiveData<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: List<CategoryEntity>)

    @Query("DELETE FROM category_database")
    fun deleteAll()


}