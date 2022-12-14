package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    //@POST("pls/apex/pmstest/MobileApp/login")

    @POST("auth/login")
    suspend fun pushLogin(@Body post: LoginRequest): LoginResponse

}