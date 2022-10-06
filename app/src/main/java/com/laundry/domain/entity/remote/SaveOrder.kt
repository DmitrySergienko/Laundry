package com.laundry.domain.entity.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SaveOrder(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("statusCode")
	val statusCode: String? = null
) : Parcelable

//@Parcelize
//data class CategoriesItem(
//
//	@field:SerializedName("image")
//	val image: String? = null,
//
//	@field:SerializedName("question")
//	val question: String? = null,
//
//	@field:SerializedName("id")
//	val id: Int? = null,
//
//	@field:SerializedName("isActive")
//	val isActive: Int? = null,
//
//	@field:SerializedName("subcategories")
//	val subcategories: List<SubcategoriesItem?>? = null,
//
//	@field:SerializedName("text")
//	val text: String? = null
//) : Parcelable

//@Parcelize
//data class SubcategoriesItem(
//
//	@field:SerializedName("image")
//	val image: String? = null,
//
//	@field:SerializedName("id")
//	val id: Int? = null,
//
//	@field:SerializedName("text")
//	val text: String? = null,
//
//	@field:SerializedName("isActive")
//	val isActive: Int? = null
//) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null
) : Parcelable
