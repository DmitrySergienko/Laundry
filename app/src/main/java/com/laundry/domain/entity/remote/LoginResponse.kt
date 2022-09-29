package com.laundry.domain.entity.remote

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("statusCode")
    val pLOGIN_FLAG: Int? = null,

    @field:SerializedName("token")
    val pTOKEN: String? = null,

    @field:SerializedName("data")
    val pRESPONSE_DATA: ResponseData? = null,
)

data class ResponseData(

    @field:SerializedName("_id")
    val _ID: String? = null,

    @field:SerializedName("email")
    val pEMAIL: String? = null,

    @field:SerializedName("fullname")
    val pFULL_NAME: String? = null,

    @field:SerializedName("phonenumber")
    val pPHONE: String? = null,

    @field:SerializedName("role")
    val pROLE: Int? = null,

    )