package com.laundry.domain.entity.remote

import com.google.gson.annotations.SerializedName

data class Registration(

    @field:SerializedName("full_name")
    val pFULLNAME: String? = null,

    @field:SerializedName("email")
    val pEMAIL: String? = null,

    @field:SerializedName("phone_number")
    val pPHONE: String? = null,

    @field:SerializedName("password")
    val pPASSWORD: String? = null,

    @field:SerializedName("confirmpassword")
    val pCONFIRMPASSWORD: String? = null,

    @field:SerializedName("role")
    val pROLE: String? = null
)
