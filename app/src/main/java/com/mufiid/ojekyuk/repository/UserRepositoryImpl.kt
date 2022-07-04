package com.mufiid.ojekyuk.repository

import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.event.StateEventManager
import com.mufiid.ojekyuk.network.NetworkSource
import com.mufiid.ojekyuk.utils.default
import org.koin.core.annotation.Single

@Single
class UserRepositoryImpl(
    private val networkSource: NetworkSource
): UserRepository {
    private val _userStateEventManager = default<List<User>>()
    override val userStateEventManager: StateEventManager<List<User>>
        get() = _userStateEventManager

    override suspend fun getUsers(page: Int) {
        networkSource.getList(page)
            .collect(_userStateEventManager)
    }
}