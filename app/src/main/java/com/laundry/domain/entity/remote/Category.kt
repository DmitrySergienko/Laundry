package com.laundry.domain.entity.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
) : Parcelable

@Parcelize
data class SubcategoriesItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("isActive")
	val isActive: Int? = null
) : Parcelable

@Parcelize
data class CategoriesItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("isActive")
	val isActive: Int? = null,

	@field:SerializedName("subcategories")
	val subcategories: List<SubcategoriesItem?>? = null
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null
) : Parcelable
