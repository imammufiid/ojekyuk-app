package com.mufiid.ojekyuk

import android.app.Application
import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.di.MainModule
import com.mufiid.ojekyuk.event.StateEvent
import kotlinx.coroutines.flow.Flow
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(MainModule().module)
        }
    }
}