package com.mufiid.ojekyuk.data.response.customer


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    var token: String?
)