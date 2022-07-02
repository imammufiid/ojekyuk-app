package com.mufiid.ojekyuk.network

import org.koin.core.annotation.Single

@Single
class WebProvider {

    fun get(): WebServices {
        return WebServices.build()
    }
}