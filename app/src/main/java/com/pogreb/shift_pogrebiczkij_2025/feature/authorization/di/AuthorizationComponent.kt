package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.fragment.AuthorizationFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Inject

@Component(
    modules = [
        AuthorizationModule::class,
    ],
    dependencies = [
        AuthorizationComponent.Deps::class,
    ],
)
interface AuthorizationComponent {
    fun inject(target: AuthorizationFragment)

    @Component.Builder
    interface Builder {
        fun deps(deps: Deps): Builder

        fun build(): AuthorizationComponent
    }

    class Deps @Inject constructor(
        val retrofit: Retrofit,
    )
}