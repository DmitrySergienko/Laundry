package com.laundry.domain.entity.remote

import com.google.gson.annotations.SerializedName

data class Registration(

    @field:SerializedName("full_name")
    val FULLNAME: String? = null,

    @field:SerializedName("email")
    val EMAIL: String? = null,

    @field:SerializedName("phone_number")
    val PHONE: String? = null,

    @field:SerializedName("password")
    val PASSWORD: String? = null,

    @field:SerializedName("confirmpassword")
    val CONFIRMPASSWORD: String? = null,

    @field:SerializedName("role")
    val ROLE: String? = null
)
