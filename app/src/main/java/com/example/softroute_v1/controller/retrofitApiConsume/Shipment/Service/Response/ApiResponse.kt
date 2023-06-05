package com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service.Response


import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Shipment
import com.google.gson.annotations.SerializedName

class ApiResponse<T>(
    @SerializedName("")
    val data: T?
    )