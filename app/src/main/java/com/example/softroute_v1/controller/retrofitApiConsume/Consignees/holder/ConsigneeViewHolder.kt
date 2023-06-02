package com.example.softroute_v1.controller.retrofitApiConsume.Consignees.holder

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.fragments.admin.AdminEditConsigneeFragment
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee

class ConsigneeViewHolder(view: View):RecyclerView.ViewHolder(view) {


    val consigneeName=view.findViewById<TextView>(R.id.tvNameConsignee)
    val address=view.findViewById<TextView>(R.id.tvAddress)
    val dni=view.findViewById<TextView>(R.id.tvDNI)

    val btnModificar=view.findViewById<Button>(R.id.btnModificarConsignee)
    val btnDelete=view.findViewById<Button>(R.id.btnEliminarConsignee)

    fun render(consigneeModel: Consignee){
        consigneeName.text=consigneeModel.name
        address.text=consigneeModel.address
        dni.text=consigneeModel.dni
    }
}