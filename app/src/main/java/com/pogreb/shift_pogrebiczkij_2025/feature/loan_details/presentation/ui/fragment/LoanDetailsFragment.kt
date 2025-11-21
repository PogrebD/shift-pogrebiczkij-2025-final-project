package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentLoanDetailsBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.di.LoanDetailsComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.LoanDetailsRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.ui.compose.LoanDetailsScreen
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.viewmodel.LoanDetailsViewModel
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.viewmodel.LoanDetailsViewModelFactory
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import javax.inject.Inject

class LoanDetailsFragment : Fragment() {

    companion object {
        private const val ARG_ID = "loanId"

        fun newInstance(
            loanId: Long
        ): LoanDetailsFragment {
            return LoanDetailsFragment().apply {
                arguments = bundleOf(
                    ARG_ID to loanId,
                )
            }
        }
    }

    private var loanId: Long = -1L

    @Inject
    lateinit var factory: LoanDetailsViewModelFactory

    @Inject
    lateinit var router: LoanDetailsRouter

    private lateinit var binding: FragmentLoanDetailsBinding

    private val viewModel: LoanDetailsViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as LoanDetailsComponentProvider

        val loanDetailsComponent = provider.provideLoanDetailsComponent()
        loanDetailsComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoanDetailsBinding.inflate(inflater, container, false)
        loanId = arguments?.getLong(ARG_ID) ?: -1L

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.loanDetailsComposeView.apply {
            setContent {
                AppTheme {
                    LoanDetailsScreen(
                        viewModel = viewModel,
                        id = loanId,
                        onBackClick = { router.openPreviousPage(parentFragmentManager) },
                        onMenuPageClick = { router.openMenu(parentFragmentManager) },
                    )
                }
            }
        }
    }
}