package com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Consignee
import retrofit2.Call
import retrofit2.http.GET

interface ConsigneeApiService {
    @GET("consignees")
    fun getConsignees(): Call<List<Consignee>>
}