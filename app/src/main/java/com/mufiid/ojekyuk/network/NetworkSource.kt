package com.mufiid.ojekyuk.network

import com.mufiid.ojekyuk.data.Mapper
import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.data.request.CustomerRequest
import com.mufiid.ojekyuk.data.request.LoginRequest
import com.mufiid.ojekyuk.data.response.customer.Customer
import com.mufiid.ojekyuk.data.response.customer.CustomerMapper
import com.mufiid.ojekyuk.utils.FlowState
import com.mufiid.ojekyuk.utils.asFlowStateEvent
import org.koin.core.annotation.Single

@Single
class NetworkSource(
    private val webProvider: WebProvider
) {
    suspend fun getList(page: Int): FlowState<List<User>> {
        return webProvider.get().getList(page).asFlowStateEvent {
            Mapper.mapUserResponse(it)
        }
    }

    suspend fun loginCustomer(loginRequest: LoginRequest): FlowState<String?> {
        return webProvider.get().loginCustomer(loginRequest).asFlowStateEvent {
            it.data?.token
        }
    }

    suspend fun registerCustomer(customerRequest: CustomerRequest): FlowState<Customer> {
        return webProvider.get().registerCustomer(customerRequest).asFlowStateEvent {
            CustomerMapper.responseToDomain(it.data)
        }
    }

    suspend fun getCustomerInfo(token: String): FlowState<Customer> {
        return webProvider.get().getCustomerInfo(token).asFlowStateEvent {
            CustomerMapper.responseToDomain(it.data)
        }
    }

    suspend fun updateCustomer(token: String, customerRequest: CustomerRequest): FlowState<Customer> {
        return webProvider.get().updateCustomer(token, customerRequest).asFlowStateEvent {
            CustomerMapper.responseToDomain(it.data)
        }
    }

    suspend fun loginDriver(loginRequest: LoginRequest): FlowState<String?> {
        return webProvider.get().loginDriver(loginRequest).asFlowStateEvent {
            it.data?.token
        }
    }

    suspend fun registerDriver(customerRequest: CustomerRequest): FlowState<Customer> {
        return webProvider.get().registerDriver(customerRequest).asFlowStateEvent {
            CustomerMapper.responseToDomain(it.data)
        }
    }

    suspend fun getDriverInfo(token: String): FlowState<Customer> {
        return webProvider.get().getDriverInfo(token).asFlowStateEvent {
            CustomerMapper.responseToDomain(it.data)
        }
    }

    suspend fun updateDriver(token: String, customerRequest: CustomerRequest): FlowState<Customer> {
        return webProvider.get().updateDriver(token, customerRequest).asFlowStateEvent {
            CustomerMapper.responseToDomain(it.data)
        }
    }
}