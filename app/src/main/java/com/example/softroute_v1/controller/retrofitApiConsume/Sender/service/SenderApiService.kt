package com.example.softroute_v1.controller.retrofitApiConsume.Sender.service

import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.model.Sender
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface SenderApiService {
    @GET("sender")
    suspend fun getSenders():List<Sender>

    @GET("sender/{id}")
    suspend fun getSenderById(@Path("id") id:String): List<Sender>

    @POST("sender")
    suspend fun createSender(@Body sender: Sender): Response<Sender>

    @PUT("sender/{id}")
    suspend fun updateSender(
        @Path("id") id: String,
        @Body sender: Sender
    ): Response<Sender>
}