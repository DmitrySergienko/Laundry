package com.laundry.domain.entity.remote

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

    @field:SerializedName("statusCode")
    val LOGIN_FLAG: Int? = null,

    @field:SerializedName("data")
    val DATA: Data? = null,
)
