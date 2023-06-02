package com.example.softroute_v1.controller.retrofitApiConsume.Shipments.service.response

import com.example.softroute_v1.controller.retrofitApiConsume.Shipments.model.Shipment
import com.google.gson.annotations.SerializedName

data class ApiData (
    @SerializedName("") val data: List<Shipment>
        )