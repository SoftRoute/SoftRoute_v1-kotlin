package com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service

import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.response.ConsigneesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ConsigneeApiService {

    @GET("consignees")
    suspend fun getConsignees(): List<Consignee>

    @GET("consignees/{id}")
    suspend fun getConsigneeById(@Path("id") id: String): List<Consignee>

    @POST("consignees")
    suspend fun createConsignee(@Body consignee: Consignee):Response<Consignee>
}
