package com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service

import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Shipment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ShipmentApiService {
    @GET("Shipments/{id}")
    fun getShipments(@Path("id") shipmentId: Int): Call<Shipment>

    @POST("Shipments")
    fun createShipment(@Body shipment: Shipment): Call<Shipment>

    @PUT("Shipments/{id}")
    fun updateShipment(@Path("id") shipmentId: Int, @Body shipment: Shipment): Call<Shipment>
}
