package com.laundry.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laundry.data.database.entities.CategoryEntity

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(category: CategoryEntity)

    @Query("SELECT * FROM category_database ORDER BY id ASC")
    fun readAll(): LiveData<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryList(category: List<CategoryEntity>)

    @Query("DELETE FROM category_database")
    suspend fun deleteAll()


}