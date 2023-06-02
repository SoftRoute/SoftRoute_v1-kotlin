package com.example.softroute_v1.controller.retrofitApiConsume.Consignees.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.fragments.admin.AdminConsigneesFragmentDirections
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.holder.ConsigneeViewHolder
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee



class ConsigneeAdapter(private val consigneeList: List<Consignee>) : RecyclerView.Adapter<ConsigneeViewHolder>(){

    //Encargado de coger los atributos y pintarlo, le pasamos el item (el layout que va a pdoer modificar)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsigneeViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ConsigneeViewHolder(layoutInflater.inflate(R.layout.item_consignee,parent,false))
    }

    override fun onBindViewHolder(holder: ConsigneeViewHolder, position: Int) {
         //Llama al render
        val item=consigneeList[position]
        holder.render(item)

        holder.btnModificar.setOnClickListener {
            val action = AdminConsigneesFragmentDirections.actionAdminConsigneesFragmentToAdminEditConsigneeFragment(item)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return consigneeList.size
    }


}