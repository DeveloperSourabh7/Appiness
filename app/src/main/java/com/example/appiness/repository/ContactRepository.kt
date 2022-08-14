package com.example.appiness.repository

import com.example.appiness.ds.ContactDataSource
import com.example.appiness.model.Contacts
import com.example.appiness.network.model.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactRepository(private val dataSource: ContactDataSource) {
    suspend fun Contact(): Flow<ApiResult<Contacts>> =
        flow {
            val response=dataSource.getContact()
            emit(response)
        }
}