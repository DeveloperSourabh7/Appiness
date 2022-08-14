package com.example.appiness.model

/**
 * Created by Sourabh Kumar on 14,June,2022
 */
data class Contacts(
    val dataObject: List<DataObject>,
    val message: String,
    val status: Boolean,
    val statusCode: Int
)