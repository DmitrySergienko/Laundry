package com.laundry.domain

import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import com.laundry.domain.entity.remote.Registration
import retrofit2.Response

interface EntranceRepository {

    suspend fun pushLogin(post: LoginRequest): LoginResponse
    suspend fun pushRegistration(post: Registration): Response<Void>
}