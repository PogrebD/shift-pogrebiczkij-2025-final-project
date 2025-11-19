package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di

import com.pogreb.shift_pogrebiczkij_2025.core.network.TokenManager
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.AuthorizationRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.fragment.AuthorizationFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Inject

@Component(
    modules = [
        AuthorizationModule::class,
    ],
    dependencies = [
        AuthorizationComponent.Dependencies::class,
    ],
)
interface AuthorizationComponent {
    fun inject(target: AuthorizationFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): AuthorizationComponent
    }

    class Dependencies @Inject constructor(
        val retrofit: Retrofit,
        val router: AuthorizationRouter,
        val tokenManager: TokenManager,
    )
}