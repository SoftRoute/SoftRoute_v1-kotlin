package com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Document
import retrofit2.Call
import retrofit2.http.GET

interface DocumentApiService {
    @GET("Documents")
    fun getDocumentos(): Call<List<Document>>
}