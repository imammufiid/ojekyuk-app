package com.mufiid.ojekyuk.repository

import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.data.request.CustomerRequest
import com.mufiid.ojekyuk.data.request.LoginRequest
import com.mufiid.ojekyuk.data.response.customer.Customer
import com.mufiid.ojekyuk.event.StateEventManager
import com.mufiid.ojekyuk.network.NetworkSource
import com.mufiid.ojekyuk.utils.default
import kotlinx.coroutines.flow.collect
import org.koin.core.annotation.Single

@Single
class UserRepositoryImpl(
    private val networkSource: NetworkSource
): UserRepository {
    private val _userStateEventManager = default<List<User>>()
    override val userStateEventManager: StateEventManager<List<User>>
        get() = _userStateEventManager

    private val _customerLoginEventManager = default<String?>()
    override val customerLoginEventManager: StateEventManager<String?>
        get() = _customerLoginEventManager

    private val _customerRegisterEventManager = default<Customer>()
    override val customerRegisterEventManager: StateEventManager<Customer>
        get() = _customerRegisterEventManager

    private val _customerUpdateEventManager = default<Customer>()
    override val customerUpdateEventManager: StateEventManager<Customer>
        get() = _customerUpdateEventManager

    private val _customerInfoEventManager = default<Customer>()
    override val customerInfoEventManager: StateEventManager<Customer>
        get() = _customerInfoEventManager

    override suspend fun getUsers(page: Int) {
        networkSource.getList(page)
            .collect(_userStateEventManager)
    }

    override suspend fun loginCustomer(loginRequest: LoginRequest) {
        networkSource.loginCustomer(loginRequest).collect(_customerLoginEventManager)
    }

    override suspend fun registerCustomer(customerRequest: CustomerRequest) {
        networkSource.registerCustomer(customerRequest).collect(_customerRegisterEventManager)
    }

    override suspend fun updateCustomer(customerRequest: CustomerRequest) {
        val token = ""
        networkSource.updateCustomer(token, customerRequest).collect(_customerUpdateEventManager)
    }

    override suspend fun customerInfo() {
        val token = ""
        networkSource.getCustomerInfo(token).collect(_customerInfoEventManager)
    }
}