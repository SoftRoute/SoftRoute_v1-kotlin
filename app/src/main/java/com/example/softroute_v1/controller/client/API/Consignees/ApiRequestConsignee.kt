package com.example.softroute_v1.controller.client.API.Consignees

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequestConsignee {

    @GET("consignees")
    suspend fun getConsignees():List<Consignee>

    @GET("consignees/{id}")
    suspend fun getConsigneeById(@Path("id") id: String): List<Consignee>
}