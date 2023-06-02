package com.example.softroute_v1.controller.retrofitApiConsume.Documents.service

import com.example.softroute_v1.controller.retrofitApiConsume.Documents.model.Document
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface DocumentApiService {
    @GET("documents")
    suspend fun getDocuments(): List<Document>

    @GET("documents/{id}")
    suspend fun getDocumentById(@Path("id") id:String): List<Document>

    @POST("documents")
    suspend fun createDocument(@Body document: Document): Response<Document>

    @PUT("documents/{id}")
    suspend fun updateDocument(@Path("id") id:String, @Body document: Document): Response<Document>

    @DELETE("documents/{id}")
    suspend fun deleteDocument(@Path("id") id:String): Response<Document>

}