package com.mufiid.ojekyuk.repository

import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.data.request.CustomerRequest
import com.mufiid.ojekyuk.data.request.LoginRequest
import com.mufiid.ojekyuk.data.response.customer.Customer
import com.mufiid.ojekyuk.event.StateEventManager

interface UserRepository {
    val userStateEventManager: StateEventManager<List<User>>
    val customerLoginEventManager: StateEventManager<String?>
    val customerRegisterEventManager: StateEventManager<Customer>
    val customerUpdateEventManager: StateEventManager<Customer>
    val customerInfoEventManager: StateEventManager<Customer>

    suspend fun getUsers(page: Int = 1)
    suspend fun loginCustomer(loginRequest: LoginRequest)
    suspend fun registerCustomer(customerRequest: CustomerRequest)
    suspend fun updateCustomer(customerRequest: CustomerRequest)
    suspend fun customerInfo()
}