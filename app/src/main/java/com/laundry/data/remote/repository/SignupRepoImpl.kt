package com.laundry.data.remote.repository

import com.laundry.data.remote.api.SignupApi
import com.laundry.data.utils.DataState
import com.laundry.domain.SignupRepository
import com.laundry.domain.entity.remote.Registration
import com.laundry.domain.entity.remote.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignupRepoImpl @Inject constructor(
    private val api: SignupApi
) : SignupRepository {

    override suspend fun pushRegistration(post: Registration): Flow<DataState<RegistrationResponse>> =
        flow {
            val response = api.pushRegistration(post)
            emit(DataState.Success(response))
        }.flowOn(Dispatchers.IO)

}
