package com.laundry.di

import com.laundry.data.remote.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


const val BASE_URL = "http://192.168.1.50:3000/"
const val MOCK_URL = "https://0ed08567-e57e-4016-be91-8a08763be9ce.mock.pstmn.io"

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
            .baseUrl(MOCK_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideApiForSignUp(retrofit: Retrofit) = retrofit.create(SignupApi::class.java)


    @Provides
    @Singleton
    fun provideApiForCategory(retrofit: Retrofit) = retrofit.create(CategoryApi::class.java)

    @Provides
    @Singleton
    fun provideApiForSaveOrder(retrofit: Retrofit) = retrofit.create(SaveOrderApi::class.java)

    @Provides
    @Singleton
    fun provideApiForOrderHistory(retrofit: Retrofit) = retrofit.create(OrderHistoryApi::class.java)
}
