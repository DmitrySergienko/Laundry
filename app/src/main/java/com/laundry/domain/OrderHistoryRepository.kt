package com.laundry.domain

import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.OrderHistoryResponse
import kotlinx.coroutines.flow.Flow

interface OrderHistoryRepository {

    suspend fun getOrderHistory(): Flow<DataState<OrderHistoryResponse>>
}