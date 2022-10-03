package com.laundry.di

import com.laundry.data.remote.api.AuthApi
import com.laundry.data.remote.api.CategoryApi
import com.laundry.data.remote.api.MyInterceptor
import com.laundry.data.remote.api.SignupApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//const val BASE_URL = "https://apex.oracle.com/"
const val BASE_URL = "http://192.168.1.50:3000/"

@Module
@InstallIn(SingletonComponent::class)

object AppEntryModule {



    val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()


    //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        addInterceptor(loggingInterceptor)
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
    fun provideApi(retrofit: Retrofit) = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideApiForSignUp(retrofit: Retrofit) = retrofit.create(SignupApi::class.java)


    @Provides
    @Singleton
    fun provideApiForCategory(retrofit: Retrofit) = retrofit.create(CategoryApi::class.java)


}
