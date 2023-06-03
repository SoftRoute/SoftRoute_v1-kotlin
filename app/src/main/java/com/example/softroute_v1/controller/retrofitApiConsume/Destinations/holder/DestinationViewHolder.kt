package com.example.softroute_v1.controller.retrofitApiConsume.Destinations.holder

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.model.Destination

class DestinationViewHolder(view:View): RecyclerView.ViewHolder(view) {
    val destinationName=view.findViewById<TextView>(R.id.tvDestinationName)
    val deleteDestination=view.findViewById<Button>(R.id.btnDeleteDestination)

    fun render(destinationModel:Destination){
        destinationName.text=destinationModel.name
    }

    fun deleteDestination(destinationModel: Destination, onDeleteClick:(Destination)->Unit){
        destinationName.text=destinationModel.name
        deleteDestination.setOnClickListener{
            onDeleteClick(destinationModel)
        }


    }
}