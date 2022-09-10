package com.laundry.domain.entity

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @field:SerializedName("P_EMAIL")
    val pEMAIL: String? = null,

    @field: SerializedName("P_PASSWORD")
    val pPASSWORD: String? = null
)