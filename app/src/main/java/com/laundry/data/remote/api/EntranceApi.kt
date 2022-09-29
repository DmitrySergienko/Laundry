package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import com.laundry.domain.entity.remote.Registration
import com.laundry.domain.entity.remote.RegistrationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface EntranceApi {

    //@POST("pls/apex/pmstest/MobileApp/login")
    @POST("auth/login")
    suspend fun pushLogin(@Body post: LoginRequest): LoginResponse


}