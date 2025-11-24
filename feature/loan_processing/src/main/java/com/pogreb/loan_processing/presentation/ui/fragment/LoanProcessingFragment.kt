package com.pogreb.loan_processing.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pogreb.design.theme.AppTheme
import com.pogreb.loan_processing.databinding.FragmentLoanProcessingBinding
import com.pogreb.loan_processing.di.LoanProcessingComponentProvider
import com.pogreb.loan_processing.presentation.LoanProcessingRouter
import com.pogreb.loan_processing.presentation.ui.compose.LoanProcessingScreen
import com.pogreb.loan_processing.presentation.viewmodel.LoanProcessingViewModel
import com.pogreb.loan_processing.presentation.viewmodel.LoanProcessingViewModelFactory
import javax.inject.Inject

class LoanProcessingFragment : Fragment() {

    companion object {
        private const val ARG_PERCENT = "percent"
        private const val ARG_PERIOD = "period"
        private const val ARG_AMOUNT = "amount"

        fun newInstance(
            percent: Double,
            period: Int,
            amount: Long,
        ): LoanProcessingFragment {
            return LoanProcessingFragment().apply {
                arguments = bundleOf(
                    ARG_PERCENT to percent,
                    ARG_PERIOD to period,
                    ARG_AMOUNT to amount,
                )
            }
        }
    }

    private var percent: Double = -1.0
    private var period: Int = -1
    private var amount: Long = -1L

    @Inject
    lateinit var factory: LoanProcessingViewModelFactory

    @Inject
    lateinit var router: LoanProcessingRouter

    private lateinit var binding: FragmentLoanProcessingBinding

    private val viewModel: LoanProcessingViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as LoanProcessingComponentProvider

        val loanProcessingComponent = provider.provideLoanProcessingComponent()
        loanProcessingComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoanProcessingBinding.inflate(inflater, container, false)
        percent = arguments?.getDouble(ARG_PERCENT) ?: -1.0
        period = arguments?.getInt(ARG_PERIOD) ?: -1
        amount = arguments?.getLong(ARG_AMOUNT) ?: -1L

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.loanProcessingComposeView.apply {
            setContent {
                AppTheme {
                    LoanProcessingScreen(
                        viewModel = viewModel,
                        percent = percent,
                        period = period,
                        amount = amount,
                        onCloseClick = { router.openMainPage(parentFragmentManager) },
                        onViewAddressClick = { router.openBankAddresses(parentFragmentManager) },
                    )
                }
            }
        }
    }
}