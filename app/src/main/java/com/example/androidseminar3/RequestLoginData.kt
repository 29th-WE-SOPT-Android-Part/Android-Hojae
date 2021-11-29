package com.example.androidseminar3

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    @SerializedName("email")
    val id : String,
    val password : String
)
