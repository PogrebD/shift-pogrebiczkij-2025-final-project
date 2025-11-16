package com.pogreb.shift_pogrebiczkij_2025.app

import android.app.Application
import android.content.Context
import com.pogreb.shift_pogrebiczkij_2025.app.di.AppComponent
import com.pogreb.shift_pogrebiczkij_2025.app.di.DaggerAppComponent


class App : Application() {

    private var _appComponent: AppComponent? = null
    val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            error("appComponent is not initialized")
        }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.factory().create(this)
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }