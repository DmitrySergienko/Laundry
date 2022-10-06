package com.laundry.domain.usecases

import com.laundry.data.utils.DataState
import com.laundry.data.utils.NetworkHelper
import com.laundry.domain.SaveOrderRepository
import com.laundry.domain.entity.remote.SaveOrder
import com.laundry.domain.entity.remote.SaveOrderResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveOrderUseCase @Inject constructor(
    private val repository:SaveOrderRepository

): NetworkHelper<SaveOrderUseCase.Params, SaveOrderResponse>() {

    class Params(val request: SaveOrder)

    override suspend fun buildUseCase(parameter: Params): Flow<DataState<SaveOrderResponse>> {
        return repository.pushSaveOrder(parameter.request)
    }
}
