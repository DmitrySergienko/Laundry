package com.laundry.domain

import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.Registration
import com.laundry.domain.entity.remote.RegistrationResponse
import kotlinx.coroutines.flow.Flow

interface SignupRepository {

    suspend fun pushRegistration(post: Registration): Flow<DataState<RegistrationResponse>>
}