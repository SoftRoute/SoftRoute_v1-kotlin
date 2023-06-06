package com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Sender
import retrofit2.Call
import retrofit2.http.GET

interface SenderApiService {
    @GET("sender")
    fun getRemitentes(): Call<List<Sender>>
}