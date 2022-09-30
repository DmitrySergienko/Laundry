package com.laundry.data.remote.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzIxYTk3MTU1N2UxMjVjZDkwYTI0MjQiLCJlbWFpbCI6InJlc2htYUB0ZWNoY2Fycm90LmFlIiwiZnVsbG5hbWUiOiJSZXNobWEgSiIsInBob25lbnVtYmVyIjoiMDU2Nzg3ODk4Iiwicm9sZSI6IjAiLCJpYXQiOjE2NjQ1MjUyNDN9.lT1UpiJziwbf_AyhnMdU6B_KH2rNIv_g4_C5PlO3eFk")
            .build()
        return chain.proceed(request)
    }
}