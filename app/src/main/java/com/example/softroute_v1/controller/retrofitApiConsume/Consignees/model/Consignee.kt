package com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Consignee (
    val id: Int,
    val dni: String,
    val address: String,
    val name: String
        ):Parcelable

