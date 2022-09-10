package com.laundry.data.remote.api

import com.laundry.domain.entity.LoginRequest
import com.laundry.domain.entity.LoginResponse
import com.laundry.domain.entity.Registration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface EntranceApi {

    @POST("pls/apex/pmstest/MobileApp/login")
    suspend fun pushLogin(@Body post: LoginRequest): LoginResponse

    @POST("pls/apex/pmstest/MobileApp/registration")
    suspend fun pushRegistration(@Body post: Registration): Response<Void>

}