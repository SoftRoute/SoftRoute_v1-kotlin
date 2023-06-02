package com.example.softroute_v1.controller.retrofitApiConsume.Sender.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sender(
    val id:Int,
    val name: String,
    val email:String
): Parcelable
