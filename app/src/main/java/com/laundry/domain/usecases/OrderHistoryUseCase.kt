package com.laundry.domain.usecases

import com.laundry.data.utils.DataState
import com.laundry.data.utils.NetworkHelper
import com.laundry.domain.OrderHistoryRepository
import com.laundry.domain.entity.remote.OrderHistoryResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderHistoryUseCase  @Inject constructor(
    private val repository:OrderHistoryRepository

)  : NetworkHelper<OrderHistoryUseCase.Params, OrderHistoryResponse>(){

    class Params

    override suspend fun buildUseCase(parameter: Params): Flow<DataState<OrderHistoryResponse>> {
        return repository.getOrderHistory()
    }

}
