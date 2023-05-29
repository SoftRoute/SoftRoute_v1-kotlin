package com.example.softroute_v1.controller.client.API.Deliveries


import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequestDelivery {

    @GET("deliveries")
    suspend fun getDeliveries():List<Delivery>

    @GET("deliveries/{id}")
    suspend fun getDeliverieById(@Path("id") id: String): List<Delivery>


}