package com.example.softroute_v1.controller.retrofitApiConsume.Shipments.model

data class Shipment(
    val id: Int,
    val description: String,
    val quantity: Int,
    val freight: Int,
    val weight: Int,
    val date: String,
    val destinyId: Int,
    val consigneesId: Int,
    val senderId: Int,
    val typeOfPackageId: Int,
    val documentId: Int
)
