package com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.di

import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.BankAddressesRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.ui.fragment.BankAddressesFragment
import dagger.Component
import javax.inject.Inject

@Component(
    dependencies = [
        BankAddressesComponent.Dependencies::class,
    ],
)
interface BankAddressesComponent {
    fun inject(target: BankAddressesFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): BankAddressesComponent
    }

    class Dependencies @Inject constructor(
        val router: BankAddressesRouter,
    )
}