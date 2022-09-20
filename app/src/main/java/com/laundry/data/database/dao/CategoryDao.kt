package com.laundry.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laundry.data.database.entities.CategoryEntity

@Dao
interface CategoryDao {

    //get all column from the table
    @Query("SELECT * FROM category_database")
    fun getAll(): List<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: List<CategoryEntity>)
}