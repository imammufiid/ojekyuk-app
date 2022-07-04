package com.mufiid.ojekyuk.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.event.StateEventSubscriber
import com.mufiid.ojekyuk.repository.UserRepository
import com.mufiid.ojekyuk.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope


@Scope(MainActivity::class)
class MainViewModel(
    private val userRepository: UserRepository
): ViewModel() {
    private val userManager = userRepository.userStateEventManager

    private val userScope = userManager.createScope(viewModelScope)

    fun subscribeUser(subscriber: StateEventSubscriber<List<User>>) {
        convertEventToSubscriber(userManager, subscriber)
    }

    fun getUsers(page: Int) = userScope.launch {
        userRepository.getUsers(page)
    }
}