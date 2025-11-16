package com.pogreb.shift_pogrebiczkij_2025.app.di

import android.content.Context
import com.pogreb.shift_pogrebiczkij_2025.app.MainActivity
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import dagger.BindsInstance
import dagger.Component


@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(target: MainActivity)

    fun authorizationComponent(): AuthorizationComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}