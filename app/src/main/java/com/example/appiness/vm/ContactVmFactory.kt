package com.example.appiness.vm


/**
 * Created by Sourabh Kumar on 14,June,2022
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appiness.repository.ContactRepository
import java.lang.IllegalArgumentException

class ContactVmFactory (private val repo: ContactRepository?=null): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactVm::class.java)){
            return ContactVm(repo!!) as T
        }
        throw IllegalArgumentException("Cannot find ViewModel")
    }
}