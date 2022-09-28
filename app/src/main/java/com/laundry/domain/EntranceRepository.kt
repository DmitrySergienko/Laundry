package com.laundry.domain

import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import com.laundry.domain.entity.remote.Registration
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface EntranceRepository {

    suspend fun pushLogin(post: LoginRequest): Flow<DataState<LoginResponse>>
    suspend fun pushRegistration(post: Registration): Response<Void>
}