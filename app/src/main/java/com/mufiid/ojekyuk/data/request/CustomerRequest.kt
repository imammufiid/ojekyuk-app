package com.mufiid.ojekyuk.data.request

data class CustomerRequest(
    var username: String,
    var password: String,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String
)
