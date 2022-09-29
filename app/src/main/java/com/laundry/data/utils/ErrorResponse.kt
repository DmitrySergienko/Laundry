package com.laundry.data.utils

import com.google.gson.annotations.SerializedName

data class ErrorResponse(

    @SerializedName("statusCode")
    val code: Int? = null,

    @SerializedName("message")
    val errorMessage: List<String>? = null,

    @SerializedName("error")
    val errorResponse: String? = null,

): Exception()
