package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.MainPageRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.fragment.MainPageFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Inject

@Component(
    modules = [
        MainPageModule::class,
    ],
    dependencies = [
        MainPageComponent.Dependencies::class
    ]
)
interface MainPageComponent {
    fun inject(target: MainPageFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): MainPageComponent
    }

    class Dependencies @Inject constructor(
        val retrofit: Retrofit,
        val router: MainPageRouter,
    )
}