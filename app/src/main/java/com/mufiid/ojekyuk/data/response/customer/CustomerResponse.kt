package com.mufiid.ojekyuk.data.response.customer


import com.google.gson.annotations.SerializedName

data class CustomerResponse(
    @SerializedName("expiredAt")
    var expiredAt: Long?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("role")
    var role: String?,
    @SerializedName("updatedAt")
    var updatedAt: Long?,
    @SerializedName("username")
    var username: String?
)