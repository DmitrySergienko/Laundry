package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.OrderHistoryResponse
import retrofit2.http.GET

interface OrderHistoryApi {

    @GET("service/orderhistory")
    suspend fun getOrderHistoryList(): OrderHistoryResponse
}
