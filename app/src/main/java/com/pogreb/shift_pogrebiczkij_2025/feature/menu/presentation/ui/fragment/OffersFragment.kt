package com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentOffersBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.di.MenuComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.MenuRouter
import javax.inject.Inject

class OffersFragment : Fragment() {

    companion object {
        fun newInstance(): OffersFragment {
            return OffersFragment()
        }
    }

    @Inject
    lateinit var router: MenuRouter

    private lateinit var binding: FragmentOffersBinding

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
        binding = FragmentOffersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.primaryButton.setOnClickListener {
            router.openBankAddresses(parentFragmentManager)
        }

        binding.closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}