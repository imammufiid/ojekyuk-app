package com.mufiid.ojekyuk.data.response.driver

object DriverMapper {
    fun responseToDomain(driverResponse: DriverResponse?): Driver {
        return Driver(
            id = driverResponse?.id,
            username = driverResponse?.username,
            password = driverResponse?.password,
            role = driverResponse?.role,
            expiredAt = driverResponse?.expiredAt,
            updatedAt = driverResponse?.updatedAt
        )
    }
}