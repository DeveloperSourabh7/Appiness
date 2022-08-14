package com.example.appiness.network.model

/**
 * Created by Sourabh Kumar on 14,June,2022
 */
data class Error(
    val status_code: Int = 0,
    val status_message: String? = null
)