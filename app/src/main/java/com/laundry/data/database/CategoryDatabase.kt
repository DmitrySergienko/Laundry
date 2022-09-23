package com.laundry.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.laundry.data.database.dao.CategoryDao
import com.laundry.data.database.entities.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = true)
abstract class CategoryDatabase: RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao

    companion object{

        @Volatile
        private var INSTANCE: CategoryDatabase? = null

        fun getDb(context: Context):CategoryDatabase{
            val tempInstance = INSTANCE
            if(tempInstance !=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoryDatabase::class.java,
                    "main_order"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}