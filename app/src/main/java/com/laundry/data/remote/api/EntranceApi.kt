package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import com.laundry.domain.entity.remote.Registration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface EntranceApi {

    //@POST("pls/apex/pmstest/MobileApp/login")
    @POST("auth/login")
    suspend fun pushLogin(@Body post: LoginRequest): LoginResponse

    @POST("pls/apex/pmstest/MobileApp/registration")
    suspend fun pushRegistration(@Body post: Registration): Response<Void>

}