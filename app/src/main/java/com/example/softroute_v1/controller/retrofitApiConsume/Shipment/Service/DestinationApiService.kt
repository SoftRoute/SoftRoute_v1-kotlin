package com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Destination
import retrofit2.Call
import retrofit2.http.GET

interface DestinationApiService {
    @GET("Destinations")
    fun getDestinations(): Call<List<Destination>>
}
