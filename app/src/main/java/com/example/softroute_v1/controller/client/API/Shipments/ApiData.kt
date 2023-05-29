package com.example.softroute_v1.controller.client.API.Shipments

import com.google.gson.annotations.SerializedName

data class ApiData (
    @SerializedName("") val data: List<Shipment>
        )