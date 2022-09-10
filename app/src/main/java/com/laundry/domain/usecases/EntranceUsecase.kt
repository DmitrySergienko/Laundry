package com.laundry.domain.usecases

import com.laundry.domain.entity.LoginRequest
import com.laundry.domain.entity.LoginResponse
import com.laundry.domain.entity.Registration
import retrofit2.Response

interface EntranceUsecase {

    suspend fun pushLogin(post: LoginRequest):LoginResponse
    suspend fun pushRegistration(post: Registration): Response<Void>
}