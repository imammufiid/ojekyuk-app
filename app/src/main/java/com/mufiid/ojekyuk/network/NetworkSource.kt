package com.mufiid.ojekyuk.network

import com.mufiid.ojekyuk.data.User

class NetworkSource(
    private val webProvider: WebProvider
) {
    suspend fun getList(page: Int): List<User> {
        webProvider.get().getList(page)
        return emptyList()
    }
}