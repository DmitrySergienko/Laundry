package com.laundry.domain.entity.remote

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @field:SerializedName("email")
    val EMAIL: String? = null,

    @field: SerializedName("password")
    val PASSWORD: String? = null
)