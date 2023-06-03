package com.example.softroute_v1.controller.retrofitApiConsume.Destinations.service

import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.model.Destination
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DestinationApiService {
    @GET("destinations")
    suspend fun getDestinations(): List<Destination>

    @GET("destinations/{id}")
    suspend fun getDestinationById(@Path("id") id:String):List<Destination>

    @POST("destinations")
    suspend fun createDestination(@Body destination: Destination): Response<Destination>

    @DELETE("destinations/{id}")
    suspend fun deleteDestination(@Path("id") id:Int): Response<Destination>


}