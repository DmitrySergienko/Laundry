package com.laundry.data.remote.repository

import com.laundry.data.remote.api.EntranceApi
import com.laundry.data.utils.DataState
import com.laundry.domain.EntranceRepository
import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import com.laundry.domain.entity.remote.Registration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EntranceRepoImpl @Inject constructor(
    private val api: EntranceApi
) : EntranceRepository {


    override suspend fun pushLogin(post: LoginRequest): Flow<DataState<LoginResponse>> =
        flow{
            val response = api.pushLogin(post)
            emit(DataState.Success(response))
        }.flowOn(Dispatchers.IO)



    override suspend fun pushRegistration(post: Registration): Response<Void> {
        return api.pushRegistration(post)
    }
}