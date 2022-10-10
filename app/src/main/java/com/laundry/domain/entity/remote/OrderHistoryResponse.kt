package com.laundry.domain.entity.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrderHistoryResponse(

	@field:SerializedName("OrderHistoryResponse")
	val orderHistoryResponse: List<OrderHistoryResponseItem?>? = null
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("address")
	val address: List<AddressItem?>? = null,

	@field:SerializedName("total_amount")
	val totalAmount: Int? = null,

	@field:SerializedName("total_quantity")
	val totalQuantity: Int? = null,

	@field:SerializedName("order")
	val order: List<OrderItem?>? = null
) : Parcelable


@Parcelize
data class OrderHistoryResponseItem(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("statusCode")
	val statusCode: String? = null
) : Parcelable


