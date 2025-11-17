package com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentOnboardingBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.OnboardingComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.OnboardingRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.compose.OnboardingScreen
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.viewmodel.OnboardingViewModel
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.viewmodel.OnboardingViewModelFactory
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import javax.inject.Inject

class OnboardingFragment : Fragment() {

    companion object {
        fun newInstance(): OnboardingFragment {
            return OnboardingFragment()
        }
    }

    @Inject
    lateinit var factory: OnboardingViewModelFactory

    @Inject
    lateinit var router: OnboardingRouter

    private lateinit var binding: FragmentOnboardingBinding

    private val viewModel: OnboardingViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as OnboardingComponentProvider

        val onboardingComponent = provider.provideOnboardingComponent()
        onboardingComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.onboardingComposeView.apply {
            setContent {
                AppTheme {
                    OnboardingScreen(
                        viewModel = viewModel,
                        onCloseClick = {
                            router.openMainPage(parentFragmentManager)
                        },
                    )
                }
            }
        }
    }
}