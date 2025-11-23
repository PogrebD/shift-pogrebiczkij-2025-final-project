package com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentLanguageBinding

class LanguageFragment : Fragment() {

    companion object {
        fun newInstance(): LanguageFragment {
            return LanguageFragment()
        }
    }

    private lateinit var binding: FragmentLanguageBinding
    private lateinit var languageAdapter: LanguageAdapter

    private val options = listOf(
        R.string.label_ru,
        R.string.label_en,
        R.string.label_de,
        R.string.label_ky
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLanguageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        languageAdapter = LanguageAdapter(
            options = options,
            onOptionSelected = { position ->
                languageAdapter.setSelectedPosition(position)
                onLanguageSelected()
            }
        )

        binding.languageRecyclerView.apply {
            this.adapter = languageAdapter
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = null
        }

        languageAdapter.setSelectedPosition(0)
    }

    private fun onLanguageSelected() {
        Toast.makeText(requireContext(), getString(R.string.label_nothing), Toast.LENGTH_SHORT)
            .show()
    }

    private fun setupClickListeners() {
        binding.closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.primaryButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}