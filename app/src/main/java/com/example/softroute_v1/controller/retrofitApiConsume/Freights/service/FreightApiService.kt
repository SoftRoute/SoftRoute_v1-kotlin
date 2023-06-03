package com.example.softroute_v1.controller.retrofitApiConsume.Freights.service
import com.example.softroute_v1.controller.retrofitApiConsume.Freights.model.Freight
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FreightApiService {
    @GET("freights")
    suspend fun getShipments():List<Freight>

    @GET("freights/{id}")
    suspend fun getShipmentById(@Path("id") id: String): List<Freight>


    @POST("freights")
    suspend fun createShipment(@Body freight: Freight): Response<Freight>
}