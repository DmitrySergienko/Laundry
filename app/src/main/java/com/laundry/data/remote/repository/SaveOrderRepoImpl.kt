package com.laundry.data.remote.repository

import com.laundry.data.remote.api.SaveOrderApi
import com.laundry.data.utils.DataState
import com.laundry.domain.SaveOrderRepository
import com.laundry.domain.entity.remote.SaveOrder
import com.laundry.domain.entity.remote.SaveOrderResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SaveOrderRepoImpl @Inject constructor(
    private val api: SaveOrderApi
): SaveOrderRepository {

    override suspend fun pushSaveOrder(post: SaveOrder): Flow<DataState<SaveOrderResponse>> =
        flow{
            val response = api.pushSaveOrder(post)
            emit(DataState.Success(response))
        }.flowOn(Dispatchers.IO)

}
