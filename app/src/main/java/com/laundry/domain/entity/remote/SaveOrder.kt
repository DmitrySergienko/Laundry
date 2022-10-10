package com.laundry.domain.entity.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SaveOrder(

	@field:SerializedName("data")
	val data: Data? = null
) : Parcelable
