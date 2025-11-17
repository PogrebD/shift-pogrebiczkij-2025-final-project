package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentMainPageBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.MainPageComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.MainPageRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.compose.MainPageScreen
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.viewmodel.MainPageViewModel
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.viewmodel.MainPageViewModelFactory
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import javax.inject.Inject

class MainPageFragment : Fragment() {

    companion object {
        fun newInstance(): MainPageFragment {
            return MainPageFragment()
        }
    }

    @Inject
    lateinit var factory: MainPageViewModelFactory

    @Inject
    lateinit var router: MainPageRouter

    private lateinit var binding: FragmentMainPageBinding

    private val viewModel: MainPageViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as MainPageComponentProvider

        val mainPageComponent = provider.provideMainPageComponent()
        mainPageComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainPageComposeView.apply {
            setContent {
                AppTheme {
                    MainPageScreen(
                        viewModel = viewModel,
                        onQuestionClick = { router.openOnboarding(parentFragmentManager) },
                        onMenuPageClick = { router.openMenu(parentFragmentManager) },
                        onContinueClick = { router.openLoanProcessing(parentFragmentManager) },
                        onViewAllClick = { router.openLoansHistory(parentFragmentManager) }
                    )
                }
            }
        }
    }
}