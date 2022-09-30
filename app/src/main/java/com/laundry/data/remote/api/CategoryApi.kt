package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.CategoryResponse
import retrofit2.http.GET

interface CategoryApi {

    @GET("service/allservices")
    suspend fun getCategoryList():CategoryResponse

}