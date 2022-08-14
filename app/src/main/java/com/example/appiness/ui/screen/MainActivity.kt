package com.example.appiness.ui.screen
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appiness.R
import com.example.appiness.databinding.ActivityMainBinding
import com.example.appiness.ds.ContactDataSource
import com.example.appiness.model.Heirarchy
import com.example.appiness.network.CustomService
import com.example.appiness.network.ServiceBuilder
import com.example.appiness.repository.ContactRepository
import com.example.appiness.ui.adapter.ContactsAdapter
import com.example.appiness.vm.ContactVm
import com.example.appiness.vm.ContactVmFactory

/**
 * Created by Sourabh Kumar on 14,June,2022
 */
class MainActivity : AppCompatActivity() {
    private val myViewModel: ContactVm by viewModels {
        ContactVmFactory(
            ContactRepository(
                ContactDataSource(
                    ServiceBuilder.buildService(CustomService::class.java)
                )
            )
        )
    }

    private var arrayList = ArrayList<Heirarchy>()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = myViewModel

        myViewModel.getContactDetails()

        myViewModel.contactLiveData.observe(this) { it ->

            val contactData = it.dataObject[0].myHierarchy[0].heirarchyList
            arrayList = contactData as ArrayList<Heirarchy>


            val adapter = ContactsAdapter(arrayList, this)
            binding.rvContact.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            val decor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

            binding.rvContact.addItemDecoration(decor)

            binding.rvContact.adapter = adapter

            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }
            })
        }

        myViewModel.exceptionLiveData.observe(this){it->
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        }
    }
}