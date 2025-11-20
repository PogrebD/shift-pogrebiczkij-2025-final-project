package com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentBankAddressesBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.di.BankAddressesComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.BankAddressesRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.ui.compose.BankAddressesScreen
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import javax.inject.Inject

class BankAddressesFragment : Fragment() {

    companion object {
        fun newInstance(): BankAddressesFragment {
            return BankAddressesFragment()
        }
    }

    @Inject
    lateinit var router: BankAddressesRouter

    private lateinit var binding: FragmentBankAddressesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as BankAddressesComponentProvider

        val bankAddressesComponent = provider.provideBankAddressesComponent()
        bankAddressesComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBankAddressesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.bankAddressesComposeView.apply {
            setContent {
                AppTheme {
                    BankAddressesScreen(
                        onBackToMainClick = { router.openMainPage(parentFragmentManager) }
                    )
                }
            }
        }
    }
}