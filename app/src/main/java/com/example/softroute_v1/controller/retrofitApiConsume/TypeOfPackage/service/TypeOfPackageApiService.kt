package com.example.softroute_v1.controller.retrofitApiConsume.TypeOfPackage.service

import com.example.softroute_v1.controller.retrofitApiConsume.TypeOfPackage.model.TypeOfPackage
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TypeOfPackageApiService {

    @GET("typeofpackage")
    suspend fun getTypeOfPackage(): List<TypeOfPackage>

    @GET("typeofpackage/{id}")
    suspend fun getTypeOfPackageById(@Path("id") id:String): List<TypeOfPackage>

}