package com.example.softroute_v1.controller.retrofitApiConsume.Destinations.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.holder.DestinationViewHolder
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.model.Destination

class DestinationAdapter (private val destinationList:MutableList<Destination>): RecyclerView.Adapter<DestinationViewHolder>(){
    private var onDeleteClickListener: ((Destination) -> Unit)? = null
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

//        onDeleteClickListener?.let { holder.deleteDestination(item , it) }

        onDeleteClickListener?.let { listener ->
            holder.deleteDestination.setOnClickListener {
                listener(item)
            }
        }
    }

    fun setOnDeleteClickListener(listener: (Destination) -> Unit) {
        onDeleteClickListener = listener
    }

    fun removeDestination(destination: Destination) {
        val index = destinationList.indexOf(destination)
        if (index != -1) {
            destinationList.removeAt(index)
            notifyItemRemoved(index)
        }
    }

}