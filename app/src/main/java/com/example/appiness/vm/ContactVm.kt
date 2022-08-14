package com.example.appiness.vm

/**
 * Created by Sourabh Kumar on 14,June,2022
 */
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appiness.model.Contacts
import com.example.appiness.network.model.ApiResult
import com.example.appiness.repository.ContactRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ContactVm( private val repository: ContactRepository) : ViewModel(){
    private val contactMutableLiveData = MutableLiveData<Contacts>()
    val contactLiveData: LiveData<Contacts>
        get() = contactMutableLiveData

    private val exceptionMutableLiveData = MutableLiveData<String>()
    val exceptionLiveData: LiveData<String>
        get() = exceptionMutableLiveData

    fun getContactDetails() {
        viewModelScope.launch {
            repository.Contact().collect {
                when (it.status) {
                    ApiResult.Status.SUCCESS -> {
                        contactMutableLiveData.postValue(it.data)
                    }
                    ApiResult.Status.ERROR -> {
                        exceptionMutableLiveData.postValue((it.message))
                    }
                    else -> {
                        Log.e("Response", "This is error")
                    }
                }
            }
        }
    }
}