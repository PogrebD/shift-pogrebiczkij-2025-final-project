package com.pogreb.loan_history.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pogreb.design.theme.AppTheme
import com.pogreb.loan_history.databinding.FragmentLoanHistoryBinding
import com.pogreb.loan_history.di.LoanHistoryComponentProvider
import com.pogreb.loan_history.presentation.LoanHistoryRouter
import com.pogreb.loan_history.presentation.ui.compose.LoanHistoryScreen
import com.pogreb.loan_history.presentation.viewmodel.LoanHistoryViewModel
import com.pogreb.loan_history.presentation.viewmodel.LoanHistoryViewModelFactory
import javax.inject.Inject

class LoanHistoryFragment : Fragment() {

    companion object {
        fun newInstance(): LoanHistoryFragment {
            return LoanHistoryFragment()
        }
    }

    @Inject
    lateinit var factory: LoanHistoryViewModelFactory

    @Inject
    lateinit var router: LoanHistoryRouter

    private lateinit var binding: FragmentLoanHistoryBinding

    private val viewModel: LoanHistoryViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as LoanHistoryComponentProvider

        val loanHistoryComponent = provider.provideLoanHistoryComponent()
        loanHistoryComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoanHistoryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.loanHistoryComposeView.apply {
            setContent {
                AppTheme {
                    LoanHistoryScreen(
                        viewModel = viewModel,
                        onItemClick = { id ->
                            router.openLoanDetails(
                                fragmentManager = parentFragmentManager,
                                id = id,
                            )
                        },
                        onBackClick = { router.openPreviousPage(parentFragmentManager) },
                    )
                }
            }
        }
    }
}