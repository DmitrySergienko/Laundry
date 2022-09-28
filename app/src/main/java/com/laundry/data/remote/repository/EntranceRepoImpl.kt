package com.laundry.data.remote.repository

import com.laundry.data.remote.api.EntranceApi
import com.laundry.domain.EntranceRepository
import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import com.laundry.domain.entity.remote.Registration
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EntranceRepoImpl @Inject constructor(
    private val api: EntranceApi
) : EntranceRepository {
    override suspend fun pushLogin(post: LoginRequest): LoginResponse {
        return api.pushLogin(post)
    }

    override suspend fun pushRegistration(post: Registration): Response<Void> {
        return api.pushRegistration(post)
    }
}