package com.mufiid.ojekyuk.network

import com.mufiid.ojekyuk.data.Mapper
import com.mufiid.ojekyuk.data.User
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
}