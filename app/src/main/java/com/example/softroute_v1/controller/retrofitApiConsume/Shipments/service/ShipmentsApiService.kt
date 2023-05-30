package com.example.softroute_v1.controller.retrofitApiConsume.Shipments.service

import com.example.softroute_v1.controller.retrofitApiConsume.Shipments.model.Shipment
import retrofit2.http.GET
import retrofit2.http.Path

interface ShipmentsApiService {
    @GET("shipments")
    suspend fun getShipments():List<Shipment>

    @GET("shipments/{id}")
    suspend fun getShipmentById(@Path("id") id: String): List<Shipment>

}