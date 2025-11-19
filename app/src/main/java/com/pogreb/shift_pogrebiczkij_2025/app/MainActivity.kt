package com.pogreb.shift_pogrebiczkij_2025.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.app.di.ComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.databinding.ActivityMainBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.fragment.AuthorizationFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.MainPageComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.OnboardingComponent

class MainActivity : AppCompatActivity(), ComponentProvider {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, AuthorizationFragment.newInstance())
                .commit()
        }
    }

    override fun provideAuthorizationComponent() =
        appComponent.authorizationComponent()

    override fun provideOnboardingComponent(): OnboardingComponent =
        appComponent.onboardingComponent()

    override fun provideMainPageComponent(): MainPageComponent =
        appComponent.mainPageComponent()


}