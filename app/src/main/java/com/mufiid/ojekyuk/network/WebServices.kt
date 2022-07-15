package com.mufiid.ojekyuk.network

import com.mufiid.ojekyuk.data.request.LoginRequest
import com.mufiid.ojekyuk.data.request.CustomerRequest
import com.mufiid.ojekyuk.data.request.DriverRequest
import com.mufiid.ojekyuk.data.response.BaseResponse
import com.mufiid.ojekyuk.data.response.UserDetailResponse
import com.mufiid.ojekyuk.data.response.UserResponse
import com.mufiid.ojekyuk.data.response.customer.CustomerResponse
import com.mufiid.ojekyuk.data.response.LoginResponse
import com.mufiid.ojekyuk.data.response.driver.DriverResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

typealias ResponseApi <T> = Response<BaseResponse<T>>

interface WebServices {

    @GET(EndPoint.GET_USER)
    suspend fun getList(
        @Query("page") page: Int
    ): Response<UserResponse>

    @GET(EndPoint.GET_USER_DETAIL)
    suspend fun getUserDetail(
        @Path("id") id: Int
    ): Response<UserDetailResponse>

    @POST(EndPoint.LOGIN_CUSTOMER)
    suspend fun loginCustomer(
        @Body loginRequest: LoginRequest
    ): ResponseApi<LoginResponse>

    @POST(EndPoint.REGISTER_CUSTOMER)
    suspend fun registerCustomer(
        @Body registerRequest: CustomerRequest
    ): ResponseApi<CustomerResponse>

    @GET(EndPoint.CUSTOMER)
    suspend fun getCustomerInfo(
        @Header("Authorization") token: String
    ): ResponseApi<CustomerResponse>

    @PUT(EndPoint.CUSTOMER)
    suspend fun updateCustomer(
        @Header("Authorization") token: String,
        @Body userRequest: CustomerRequest
    ): ResponseApi<CustomerResponse>

    @POST(EndPoint.LOGIN_DRIVER)
    suspend fun loginDriver(
        @Body loginRequest: LoginRequest
    ): ResponseApi<LoginResponse>

    @POST(EndPoint.REGISTER_DRIVER)
    suspend fun registerDriver(
        @Body driverRequest: DriverRequest
    ): ResponseApi<DriverResponse>

    @GET(EndPoint.DRIVER)
    suspend fun getDriverInfo(
        @Header("Authorization") token: String
    ): ResponseApi<DriverResponse>

    @PUT(EndPoint.DRIVER)
    suspend fun updateDriver(
        @Header("Authorization") token: String,
        @Body userRequest: DriverRequest
    ): ResponseApi<DriverResponse>

    companion object {
        const val BASE_URL = "https://ojekyuk-api.herokuapp.com"
        fun build(): WebServices {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebServices::class.java)
        }
    }

    object EndPoint {
        const val GET_USER = "/v1/api/users"
        const val GET_USER_DETAIL = "/v1/api/users/{id}"
        const val LOGIN_CUSTOMER = "/v1/api/customer/login"
        const val REGISTER_CUSTOMER = "/v1/api/customer/register"
        const val CUSTOMER = "/v1/api/customer"

        const val LOGIN_DRIVER = "/v1/api/driver/login"
        const val REGISTER_DRIVER = "/v1/api/driver/register"
        const val DRIVER = "/v1/api/driver"
    }
}