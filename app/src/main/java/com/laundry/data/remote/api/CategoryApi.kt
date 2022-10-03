package com.laundry.data.remote.api

import com.laundry.domain.entity.remote.CategoryResponse
import retrofit2.http.GET

interface CategoryApi {

//    @Headers(
//        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzIxYTk3MTU1N2UxMjVjZDkwYTI0MjQiLCJlbWFpbCI6InJlc2htYUB0ZWNoY2Fycm90LmFlIiwiZnVsbG5hbWUiOiJSZXNobWEgSiIsInBob25lbnVtYmVyIjoiMDU2Nzg3ODk4Iiwicm9sZSI6IjAiLCJpYXQiOjE2NjQ4NjUwMDAsImV4cCI6MTY2NDk1MTQwMH0.5UVqrUUkbECrH8LQ4IPQJA1HnbcWxiRcf8XBXv0LP30"
//    )
    @GET("service/allservices")
    suspend fun getCategoryList():CategoryResponse

}