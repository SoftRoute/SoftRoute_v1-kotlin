package com.example.softroute_v1.controller.client.API

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {
    @GET("shipments")
    suspend fun getShipments():List<Shipment>

    @GET("shipments/{id}")
    suspend fun getShipmentById(@Path("id") id: String): List<Shipment>

}