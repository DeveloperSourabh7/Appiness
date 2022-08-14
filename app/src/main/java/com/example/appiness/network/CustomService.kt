package com.example.appiness.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Sourabh Kumar on 14,June,2022
 */

interface CustomService {
    @GET("getMyList")
    fun getContact () : Call<JsonObject>
}