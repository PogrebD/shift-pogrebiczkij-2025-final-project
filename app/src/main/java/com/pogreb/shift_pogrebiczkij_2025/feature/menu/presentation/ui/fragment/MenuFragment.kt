package com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.core.network.TokenManager
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentMenuBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.di.MenuComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.MenuRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.entity.MenuItem
import javax.inject.Inject

class MenuFragment : Fragment() {

    companion object {
        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }

    @Inject
    lateinit var router: MenuRouter

    @Inject
    lateinit var tokenManager: TokenManager

    private lateinit var binding: FragmentMenuBinding

    private val menuItems = listOf(
        MenuItem(
            id = 1,
            titleResId = R.string.label_loans_history,
            action = { router.openLoansHistory(parentFragmentManager) }
        ),
        MenuItem(
            id = 2,
            titleResId = R.string.label_offers,
            action = { openOffers(parentFragmentManager) }
        ),
        MenuItem(
            id = 3,
            titleResId = R.string.label_bank_addresses,
            action = { router.openBankAddresses(parentFragmentManager) }
        ),
        MenuItem(
            id = 4,
            titleResId = R.string.label_support,
            action = { openSupport(parentFragmentManager) }
        ),
        MenuItem(
            id = 5,
            titleResId = R.string.label_language,
            action = { openLanguage(parentFragmentManager) }
        ),
        MenuItem(
            id = 6,
            titleResId = R.string.label_exit,
            action = { showExitConfirmationDialog() }
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val provider = requireActivity() as MenuComponentProvider
        val menuComponent = provider.provideMenuComponent()

        menuComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        val adapter = MenuAdapter(menuItems)
        binding.menuRecyclerView.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = null
        }
    }

    private fun setupClickListeners() {
        binding.iconHelp.setOnClickListener {
            router.openOnboarding(parentFragmentManager)
        }
    }

    private fun showExitConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.title_exit_dialog))
            .setMessage(getString(R.string.body_exit_dialog))
            .setPositiveButton(R.string.label_exit) { dialog, _ ->
                tokenManager.clearToken()
                router.openAuthorization(parentFragmentManager)
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.label_cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun openSupport(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                SupportFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    private fun openOffers(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OffersFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    private fun openLanguage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                LanguageFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }
}