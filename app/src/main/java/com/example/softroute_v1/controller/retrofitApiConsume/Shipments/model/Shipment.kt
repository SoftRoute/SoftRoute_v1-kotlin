package com.example.softroute_v1.controller.retrofitApiConsume.Shipments.model

import android.widget.DatePicker

data class Shipment(
    val id: Int,
    val typeOfPackageId: Int,
    val weight: Int,
    val quantity: Int,
    val freight: Int,
    val description: String,
    val senderId: Int,
    val consigneesId: Int,
    val documentId: Int,
    val destinyId: Int,
    val date: String,




    )
