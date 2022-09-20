package com.laundry.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laundry.data.database.dao.CategoryDao
import com.laundry.data.database.entities.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = true)
abstract class CategoryDatabase: RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
}