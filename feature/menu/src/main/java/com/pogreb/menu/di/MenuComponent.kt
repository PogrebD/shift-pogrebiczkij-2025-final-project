package com.pogreb.menu.di

import com.pogreb.core.network.TokenManager
import com.pogreb.menu.presentation.MenuRouter
import com.pogreb.menu.presentation.ui.fragment.MenuFragment
import com.pogreb.menu.presentation.ui.fragment.OffersFragment
import dagger.Component
import javax.inject.Inject

@Component(
    dependencies = [
        MenuComponent.Dependencies::class
    ]
)
interface MenuComponent {
    fun inject(target: MenuFragment)
    fun inject(target: OffersFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): MenuComponent
    }

    class Dependencies @Inject constructor(
        val tokenManager: TokenManager,
        val router: MenuRouter,
    )
}