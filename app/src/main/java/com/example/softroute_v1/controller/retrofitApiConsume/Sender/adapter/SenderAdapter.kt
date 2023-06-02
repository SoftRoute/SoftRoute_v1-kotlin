package com.example.softroute_v1.controller.retrofitApiConsume.Sender.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.holder.SenderViewHolder
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.model.Sender

class SenderAdapter(private val senderList:List<Sender>):RecyclerView.Adapter<SenderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SenderViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return SenderViewHolder(layoutInflater.inflate(R.layout.item_sender,parent,false))
    }

    override fun onBindViewHolder(holder: SenderViewHolder, position: Int) {
        val item=senderList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int {
        return senderList.size
    }

}