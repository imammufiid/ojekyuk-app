package com.mufiid.ojekyuk.data.response


import com.google.gson.annotations.SerializedName
import com.mufiid.ojekyuk.data.Data
import com.mufiid.ojekyuk.data.Support

data class UserDetailResponse(
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("support")
    var support: Support?
)