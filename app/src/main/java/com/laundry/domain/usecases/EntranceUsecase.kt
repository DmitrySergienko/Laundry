package com.laundry.domain.usecases

import com.laundry.data.utils.DataState
import com.laundry.data.utils.NetworkHelper
import com.laundry.domain.EntranceRepository
import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EntranceUsecase @Inject constructor(
    private val entranceRepository: EntranceRepository,

) : NetworkHelper<EntranceUsecase.Params, LoginResponse>() {

    class Params(val request: LoginRequest)

    override suspend fun buildUseCase(parameter: Params): Flow<DataState<LoginResponse>> {
        return entranceRepository.pushLogin(parameter.request)
    }

}