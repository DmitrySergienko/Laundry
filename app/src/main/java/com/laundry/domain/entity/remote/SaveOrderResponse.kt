package com.laundry.domain.entity.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SaveOrderResponse(

	@field:SerializedName("SaveOrderResponse")
	val saveOrderResponse: List<SaveOrderResponseItem?>? = null
) : Parcelable

@Parcelize
data class SaveOrderResponseItem(

	@field:SerializedName("statusCode")
	val statusCode: String? = null,

	@field:SerializedName("order")
	val order: List<OrderItem?>? = null
) : Parcelable

@Parcelize
data class AddressItem(

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("address1")
	val address1: String? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("state")
	val state: String? = null
) : Parcelable

//@Parcelize
//data class CategoriesItem(
//
//	@field:SerializedName("image")
//	val image: String? = null,
//
//	@field:SerializedName("totalamount")
//	val totalamount: Int? = null,
//
//	@field:SerializedName("id")
//	val id: Int? = null,
//
//	@field:SerializedName("text")
//	val text: String? = null,
//
//	@field:SerializedName("subcategories")
//	val subcategories: List<SubcategoriesItem?>? = null,
//
//	@field:SerializedName("totalquantity")
//	val totalquantity: Int? = null
//) : Parcelable

@Parcelize
data class OrderItem(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null
) : Parcelable

//@Parcelize
//data class SubcategoriesItem(
//
//	@field:SerializedName("image")
//	val image: String? = null,
//
//	@field:SerializedName("price")
//	val price: Int? = null,
//
//	@field:SerializedName("count")
//	val count: Int? = null,
//
//	@field:SerializedName("id")
//	val id: Int? = null,
//
//	@field:SerializedName("text")
//	val text: String? = null
//) : Parcelable

//@Parcelize
//data class Data(
//
//	@field:SerializedName("address")
//	val address: List<AddressItem?>? = null,
//
//	@field:SerializedName("total_amount")
//	val totalAmount: Int? = null,
//
//	@field:SerializedName("total_quantity")
//	val totalQuantity: Int? = null,
//
//	@field:SerializedName("order")
//	val order: List<OrderItem?>? = null
//) : Parcelable
