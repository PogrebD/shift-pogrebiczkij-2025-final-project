package com.pogreb.authorization.di

import com.pogreb.authorization.presentation.AuthorizationRouter
import com.pogreb.authorization.presentation.ui.fragment.AuthorizationFragment
import com.pogreb.core.network.TokenManager
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