package com.example.softroute_v1.controller.retrofitApiConsume.Deliveries.service


import com.example.softroute_v1.controller.retrofitApiConsume.Deliveries.model.Delivery
import retrofit2.http.GET
import retrofit2.http.Path

interface DeliveryApiService {

    @GET("deliveries")
    suspend fun getDeliveries():List<Delivery>

    @GET("deliveries/{id}")
    suspend fun getDeliverieById(@Path("id") id: String): List<Delivery>


}