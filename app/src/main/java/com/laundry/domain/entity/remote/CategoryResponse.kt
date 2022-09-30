package com.laundry.domain.entity.remote

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

    @field:SerializedName("statusCode")
    val pLOGIN_FLAG: Int? = null,

    @field:SerializedName("data")
    val pDATA: Data? = null,
)
