package com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.TypeOfPackage
import retrofit2.Call
import retrofit2.http.GET

interface TypeOfPackegeApiService {
    @GET("TypeOfPackage")
    fun getTipoDePaquetes(): Call<List<TypeOfPackage>>
}