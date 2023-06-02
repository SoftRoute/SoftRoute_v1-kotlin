package com.example.softroute_v1.controller.retrofitApiConsume.Sender.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.model.Sender

class SenderViewHolder(view: View):RecyclerView.ViewHolder(view){

    val senderName=view.findViewById<TextView>(R.id.tvnameSender)
    val senderEmail=view.findViewById<TextView>(R.id.tvEmailSender)

    fun render(senderModel: Sender){
        senderName.text=senderModel.name
        senderEmail.text=senderModel.email
    }
}