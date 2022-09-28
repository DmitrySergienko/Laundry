package com.laundry.data.utils

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("response")
    val errorResponse: ErrorData? = null,
): Exception()
data class ErrorData(
    @SerializedName("errCode")
    val code: Int? = null,
    @SerializedName("message")
    val errorMessage: String? = null
)
