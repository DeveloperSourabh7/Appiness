package com.example.appiness.ui.adapter

/**
 * Created by Sourabh Kumar on 14,June,2022
 */
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appiness.R
import com.example.appiness.model.Heirarchy
import com.example.appiness.utils.*
import java.util.*
import kotlin.collections.ArrayList

class ContactsAdapter(val datalist: List<Heirarchy>, val context: Context) :
   RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>(),Filterable {
        var dataFilterList=ArrayList<Heirarchy>()

    init{
        dataFilterList.addAll(datalist)
    }
       class ContactViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
           val name: TextView=itemView.findViewById(R.id.mtv_name)
           val post: TextView=itemView.findViewById(R.id.mtv_post)
           val btn: Button=itemView.findViewById(R.id.mtv_call)
           val msg: Button=itemView.findViewById(R.id.mtv_message)
       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val model=dataFilterList[position]
        holder.name.text=model.contactName
        holder.post.text=model.designationName
        holder.btn.setOnClickListener{
            Phone().phoneCall(model.contactNumber,context)
        }
        holder.msg.setOnClickListener {
           Message().sendMsg(model.contactNumber,context)
        }
    }

    override fun getItemCount(): Int {
        return dataFilterList.size
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    var k=ArrayList<Heirarchy>()
                    k.addAll(datalist)
                    dataFilterList=k
                } else {
                    val resultList = ArrayList<Heirarchy>()
                    for (row in dataFilterList) {
                        if (row.contactName.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    dataFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = dataFilterList
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                dataFilterList = p1?.values as ArrayList<Heirarchy>
                notifyDataSetChanged()
            }
        }
    }
}