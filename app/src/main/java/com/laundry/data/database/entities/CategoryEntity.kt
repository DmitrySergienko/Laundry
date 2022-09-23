package com.laundry.data.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


//@Entity(tableName = "category_bd", indices =[Index("id", unique = true)])
@Parcelize
@Entity(tableName = "category_database")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "checkbox") var checkbox: Boolean,
    @ColumnInfo(name = "image") val image: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "count") var count: Int = 0,
):Parcelable
