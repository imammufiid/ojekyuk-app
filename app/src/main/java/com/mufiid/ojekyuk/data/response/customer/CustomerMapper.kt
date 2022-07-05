package com.mufiid.ojekyuk.data.response.customer

object CustomerMapper {
    fun responseToDomain(customerResponse: CustomerResponse?): Customer {
        return Customer(
            id = customerResponse?.id,
            username = customerResponse?.username,
            password = customerResponse?.password,
            role = customerResponse?.role,
            expiredAt = customerResponse?.expiredAt,
            updatedAt = customerResponse?.updatedAt
        )
    }
}