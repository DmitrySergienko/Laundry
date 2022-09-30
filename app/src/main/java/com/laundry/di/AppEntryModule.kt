package com.laundry.di

import com.laundry.data.remote.api.EntranceApi
import com.laundry.data.remote.api.MyInterceptor
import com.laundry.data.remote.api.SignupApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//const val BASE_URL = "https://apex.oracle.com/"
const val BASE_URL = "http://192.168.1.50:3000/"

@Module
@InstallIn(SingletonComponent::class)

object AppEntryModule {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) = retrofit.create(EntranceApi::class.java)

    @Provides
    @Singleton
    fun provideApiForSignUp(retrofit: Retrofit) = retrofit.create(SignupApi::class.java)


}
