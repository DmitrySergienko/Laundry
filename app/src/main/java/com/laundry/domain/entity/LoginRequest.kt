package com.laundry.domain.entity

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @field:SerializedName("email")
    val pEMAIL: String? = null,

    @field: SerializedName("password")
    val pPASSWORD: String? = null
)