package com.example.softroute_v1.controller.client.API.Deliveries

data class Delivery(
    val id: Int,
    val date: String,
    val description: String,
    val shipmentId: Int
)
