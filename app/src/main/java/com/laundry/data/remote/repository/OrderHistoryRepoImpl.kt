package com.laundry.data.remote.repository

import com.laundry.data.remote.api.OrderHistoryApi
import com.laundry.data.utils.DataState
import com.laundry.domain.OrderHistoryRepository
import com.laundry.domain.entity.remote.OrderHistoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class OrderHistoryRepoImpl @Inject constructor(
    private val api: OrderHistoryApi

) : OrderHistoryRepository {

    override suspend fun getOrderHistory(): Flow<DataState<OrderHistoryResponse>> =
        flow {
            val response = api.getOrderHistoryList()
            emit(DataState.Success(response))
        }.flowOn(Dispatchers.IO)


}
