package com.laundry.domain.entity.remote

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("statusCode")
    val LOGIN_FLAG: Int? = null,

    @field:SerializedName("token")
    val TOKEN: String? = null,

    @field:SerializedName("data")
    val RESPONSE_DATA: ResponseData? = null,
)

data class ResponseData(

    @field:SerializedName("_id")
    val ID: String? = null,

    @field:SerializedName("email")
    val EMAIL: String? = null,

    @field:SerializedName("fullname")
    val FULL_NAME: String? = null,

    @field:SerializedName("phonenumber")
    val PHONE: String? = null,

    @field:SerializedName("role")
    val ROLE: Int? = null,

    )