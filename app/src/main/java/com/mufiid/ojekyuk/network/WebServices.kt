package com.mufiid.ojekyuk.network

import com.mufiid.ojekyuk.data.UserDetailResponse
import com.mufiid.ojekyuk.data.UserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServices {

    @GET(EndPoint.GET_USER)
    suspend fun getList(
        @Query("page") page: Int
    ): Response<UserResponse>

    @GET(EndPoint.GET_USER_DETAIL)
    suspend fun getUserDetail(
        @Path("id") id: Int
    ): Response<UserDetailResponse>

    companion object {
        const val BASE_URL = "https://reqres.in"
        fun build(): WebServices {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebServices::class.java)
        }
    }

    object EndPoint {
        const val GET_USER = "/api/users"
        const val GET_USER_DETAIL = "/api/users/{id}"
    }
}