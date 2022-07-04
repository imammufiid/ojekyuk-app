package com.mufiid.ojekyuk.repository

import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.event.StateEventManager

interface UserRepository {
    val userStateEventManager: StateEventManager<List<User>>

    suspend fun getUsers(page: Int = 1)
}