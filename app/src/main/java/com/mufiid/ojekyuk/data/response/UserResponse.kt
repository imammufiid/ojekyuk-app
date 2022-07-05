package com.mufiid.ojekyuk.data.response


import com.google.gson.annotations.SerializedName
import com.mufiid.ojekyuk.data.Data
import com.mufiid.ojekyuk.data.Support

data class UserResponse(
    @SerializedName("data")
    var data: List<Data?>?,
    @SerializedName("page")
    var page: Int?,
    @SerializedName("per_page")
    var perPage: Int?,
    @SerializedName("support")
    var support: Support?,
    @SerializedName("total")
    var total: Int?,
    @SerializedName("total_pages")
    var totalPages: Int?
)