package com.laundry.domain

import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.SaveOrder
import com.laundry.domain.entity.remote.SaveOrderResponse
import kotlinx.coroutines.flow.Flow

interface SaveOrderRepository {

    suspend fun pushSaveOrder(post:SaveOrder): Flow<DataState<SaveOrderResponse>>

}