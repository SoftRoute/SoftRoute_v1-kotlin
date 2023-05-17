package com.example.softroute_v1.admin.listRegister.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.softroute_v1.R
import com.example.softroute_v1.admin.listRegister.ListRegister

class ListRegisterViewHolder(view: View):ViewHolder(view) {
    val codigo=view.findViewById<TextView>(R.id.tvCodigo)
    val fecha=view.findViewById<TextView>(R.id.tvFecha)

    fun render(comment:ListRegister){
        codigo.text=comment.codigo
        fecha.text=comment.fecha
    }
}





