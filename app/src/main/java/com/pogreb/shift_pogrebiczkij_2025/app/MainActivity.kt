package com.pogreb.shift_pogrebiczkij_2025.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateOf
import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.app.di.ComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.databinding.ActivityMainBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.fragment.AuthorizationFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.di.BankAddressesComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.di.LoanDetailsComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.di.LoanHistoryComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.di.LoanProcessingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.MainPageComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.fragment.MainPageFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.di.MenuComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment.MenuFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.OnboardingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.fragment.OnboardingFragment
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.ActiveTab
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.TabBar
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

class MainActivity : AppCompatActivity(), ComponentProvider {
    private lateinit var binding: ActivityMainBinding
    private var currentScreen = mutableStateOf(ActiveTab.HOME)
    var availableTabBar = mutableStateOf(false)

    private val backStackListener = FragmentManager.OnBackStackChangedListener {
        updateBottomBar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomBar()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, AuthorizationFragment.newInstance())
                .commit()
        }

        setupFragmentListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.removeOnBackStackChangedListener(backStackListener)
    }

    private fun setupBottomBar() {
        binding.bottomBarComposeView.setContent {
            AppTheme {
                TabBar(
                    onMainPageClick = { openMainPage() },
                    onMenuPageClick = { openMenu() },
                    activeTab = currentScreen.value,
                    activeTabBar = availableTabBar.value,
                )
            }
        }
    }

    private fun setupFragmentListener() {
        supportFragmentManager.addOnBackStackChangedListener(backStackListener)
    }

    private fun updateBottomBar() {
        val currentFragment = supportFragmentManager
            .findFragmentById(binding.fragmentContainerView.id)

        availableTabBar.value = when (currentFragment) {
            is AuthorizationFragment -> false
            is OnboardingFragment -> false
            else -> true
        }
    }

    private fun openMenu() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, MenuFragment.newInstance())
            .commit()

        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        currentScreen.value = ActiveTab.MENU
    }

    private fun openMainPage() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, MainPageFragment.newInstance())
            .commit()

        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        currentScreen.value = ActiveTab.HOME
    }

    override fun provideAuthorizationComponent() =
        appComponent.authorizationComponent()

    override fun provideOnboardingComponent(): OnboardingComponent =
        appComponent.onboardingComponent()

    override fun provideMainPageComponent(): MainPageComponent =
        appComponent.mainPageComponent()

    override fun provideLoanProcessingComponent(): LoanProcessingComponent =
        appComponent.loanProcessingComponent()

    override fun provideBankAddressesComponent(): BankAddressesComponent =
        appComponent.bankAddressesComponent()

    override fun provideLoanHistoryComponent(): LoanHistoryComponent =
        appComponent.loanHistoryComponent()

    override fun provideLoanDetailsComponent(): LoanDetailsComponent =
        appComponent.loanDetailsComponent()

    override fun provideMenuComponent(): MenuComponent =
        appComponent.menuComponent()
}