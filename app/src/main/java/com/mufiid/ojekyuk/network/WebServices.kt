package com.mufiid.ojekyuk.network

import com.mufiid.ojekyuk.data.UserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET(EndPoint.GET_USER)
    suspend fun getList(
        @Query("page") page: Int
    ): Response<UserResponse>

    companion object {
        const val BASE_URL = "https://reqres.in"
        fun build(): WebServices {
            return Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebServices::class.java)
        }
    }

    object EndPoint {
        const val GET_USER = "/api/users"
    }
}