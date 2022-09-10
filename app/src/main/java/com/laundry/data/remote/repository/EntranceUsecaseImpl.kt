package com.laundry.data.remote.repository

import com.laundry.data.remote.api.EntranceApi
import com.laundry.domain.entity.LoginRequest
import com.laundry.domain.entity.LoginResponse
import com.laundry.domain.entity.Registration
import com.laundry.domain.usecases.EntranceUsecase
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EntranceUsecaseImpl @Inject constructor(
    private val api: EntranceApi
) : EntranceUsecase {
    override suspend fun pushLogin(post: LoginRequest): LoginResponse {
        return api.pushLogin(post)
    }

    override suspend fun pushRegistration(post: Registration): Response<Void> {
        return api.pushRegistration(post)
    }
}