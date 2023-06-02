package com.example.softroute_v1.controller.retrofitApiConsume.Destinations.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.holder.DestinationViewHolder
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.model.Destination

class DestinationAdapter (private val destinationList:List<Destination>): RecyclerView.Adapter<DestinationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return DestinationViewHolder(layoutInflater.inflate(R.layout.item_destination,parent,false))
    }

    override fun getItemCount(): Int {
        return destinationList.size
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        //call render
        val item=destinationList[position]
        holder.render(item)

//        holder.itemView.findViewById<Button>(R.id.btnDeleteDestination).setOnClickListener{
//
//        }

    }

}