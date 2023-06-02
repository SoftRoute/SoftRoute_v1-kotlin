package com.example.softroute_v1.controller.retrofitApiConsume.Deliveries.service.response

import com.example.softroute_v1.controller.retrofitApiConsume.Deliveries.model.Delivery
import com.google.gson.annotations.SerializedName

data class DeliveriesReponse (
    @SerializedName("") val data: List<Delivery>
)