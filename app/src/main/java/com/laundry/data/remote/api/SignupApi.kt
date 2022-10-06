package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.Registration
import com.laundry.domain.entity.remote.RegistrationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupApi {

    @POST("auth/register")
    suspend fun pushRegistration(@Body post: Registration): RegistrationResponse

}