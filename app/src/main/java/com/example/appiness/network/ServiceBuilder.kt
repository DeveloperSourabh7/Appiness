package com.example.appiness.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.*
import java.util.concurrent.TimeUnit

/**
 * Created by Sourabh Kumar on 14,June,2022
 */

object ServiceBuilder {
    private const val URL = "http://demo2143341.mockable.io/"

    private val interceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor()
    }
    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder().addNetworkInterceptor(
            interceptor.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).connectTimeout(300, TimeUnit.SECONDS).addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val originalHttpUrl = chain.request().url
            val url =
                originalHttpUrl.newBuilder()
                    .build()
            request.url(url)
            val response = chain.proceed(request.build())
            return@addInterceptor response

        }.readTimeout(300, TimeUnit.SECONDS).build()
    }

//    CREATE HTTP CLIENT
//    private val okHttp = OkHttpClient.Builder()

    //retrofit builder
    private val builder = Retrofit.Builder()
        .baseUrl(URL).addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)

    //create retrofit Instance
    private val retrofit = builder.build()

    //we will use this class to create an anonymous inner class function that
    //implements Custom service Interface

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}