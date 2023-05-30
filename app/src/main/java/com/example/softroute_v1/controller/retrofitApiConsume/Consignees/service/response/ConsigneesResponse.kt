package com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.response

import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.google.gson.annotations.SerializedName

data class ConsigneesResponse (
    @SerializedName("")
    val data: List<Consignee>
)