package com.laundry.domain.usecases

import com.laundry.data.utils.DataState
import com.laundry.data.utils.NetworkHelper
import com.laundry.domain.SignupRepository
import com.laundry.domain.entity.remote.Registration
import com.laundry.domain.entity.remote.RegistrationResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUsecase @Inject constructor(
    private val signupRepository: SignupRepository

) : NetworkHelper<SignUpUsecase.Params, RegistrationResponse>() {

    class Params(val request: Registration)


    override suspend fun buildUseCase(parameter: Params): Flow<DataState<RegistrationResponse>> {
        return signupRepository.pushRegistration(parameter.request)
    }

}
