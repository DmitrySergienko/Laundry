package com.laundry.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

//@Entity(tableName = "category_bd", indices =[Index("id", unique = true)])
@Entity(tableName = "category_database")
data class CategoryEntity(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "checkbox") val checkbox: Boolean,
    @ColumnInfo(name = "image") val image: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "count") val count: Int,
)
