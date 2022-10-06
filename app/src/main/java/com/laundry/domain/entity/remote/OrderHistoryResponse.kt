package com.laundry.domain.entity.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrderHistoryResponse(

	@field:SerializedName("OrderHistoryResponse")
	val orderHistoryResponse: List<OrderHistoryResponseItem?>? = null
) : Parcelable

//@Parcelize
//data class DataItem(
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

//@Parcelize
//data class AddressItem(
//
//	@field:SerializedName("address1")
//	val address1: String? = null
//) : Parcelable

//@Parcelize
//data class OrderItem(
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
data class OrderHistoryResponseItem(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("statusCode")
	val statusCode: String? = null
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
//	@field:SerializedName("text")
//	val text: String? = null
//) : Parcelable
