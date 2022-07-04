package com.mufiid.ojekyuk.data


import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("support")
    var support: Support?
)