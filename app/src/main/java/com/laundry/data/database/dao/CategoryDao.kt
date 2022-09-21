package com.laundry.data.database.dao

import android.content.Context
import androidx.room.*
import com.laundry.data.database.CategoryDatabase
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.domain.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    //get all column from the table
    @Query("SELECT * FROM category_database")
    fun getAll(): List<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: List<CategoryEntity>)


}