package com.example.appiness.ds
import com.example.appiness.model.Contacts
import com.example.appiness.network.CustomService
import com.example.appiness.network.model.ApiResult
import com.example.appiness.network.model.Error
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.awaitResponse

/**
 * Created by Sourabh Kumar on 14,June,2022
 */


class ContactDataSource(private val service: CustomService) {
    suspend fun getContact(): ApiResult<Contacts> {
        val callRequest = service.getContact()

        val response = callRequest.awaitResponse()

        return if (response.isSuccessful) {
            val data = getResponse<JsonObject>(response)
            try {
                val jsonElement = data?.asJsonObject
                val userResponse = Gson().fromJson(jsonElement, Contacts::class.java)
                ApiResult.success(data = userResponse)
            } catch (ex: Exception) {
                ApiResult.error(message = ex.localizedMessage!!)
            }
        } else {
            ApiResult.error(
                message = response.message(),
                error = Error(response.code(),response.message())
            )
        }
    }

    private fun <T> getResponse(
        response: Response<JsonObject>
    ): JsonElement? {
        return try {
            val jsonObject = response.body()
            jsonObject?.let {
                return jsonObject
            }
        } catch (e: Throwable) {
            return null
        }
    }
}