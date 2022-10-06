package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.SaveOrder
import com.laundry.domain.entity.remote.SaveOrderResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SaveOrderApi {

    @POST("service/saveorder")
    suspend fun pushSaveOrder(@Body post: SaveOrder): SaveOrderResponse
}