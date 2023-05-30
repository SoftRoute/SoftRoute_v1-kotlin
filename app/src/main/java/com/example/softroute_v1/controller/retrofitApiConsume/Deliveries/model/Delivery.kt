package com.example.softroute_v1.controller.retrofitApiConsume.Deliveries.model

data class Delivery(
    val id: Int,
    val date: String,
    val description: String,
    val shipmentId: Int
)
