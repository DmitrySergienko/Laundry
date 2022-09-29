package com.laundry.domain

import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import kotlinx.coroutines.flow.Flow

interface EntranceRepository {

    suspend fun pushLogin(post: LoginRequest): Flow<DataState<LoginResponse>>

}