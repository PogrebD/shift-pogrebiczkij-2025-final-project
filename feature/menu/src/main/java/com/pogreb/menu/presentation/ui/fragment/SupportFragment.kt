package com.pogreb.menu.presentation.ui.fragment

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.pogreb.design.R
import com.pogreb.menu.databinding.FragmentSupportBinding

class SupportFragment : Fragment() {

    companion object {
        fun newInstance(): SupportFragment {
            return SupportFragment()
        }
    }

    private lateinit var binding: FragmentSupportBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSupportBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        setupHelpText()
    }

    private fun setupHelpText() {
        val fullText = getString(R.string.body_support)
        val spannable = SpannableString(fullText)

        val phoneNumber = getString(R.string.body_support_phone)
        val phoneStart = fullText.indexOf(phoneNumber)
        val phoneEnd = phoneStart + phoneNumber.length

        if (phoneStart != -1) {
            val phoneColor = ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark)
            spannable.setSpan(
                ForegroundColorSpan(phoneColor),
                phoneStart,
                phoneEnd,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        binding.body.text = spannable
    }

    private fun setupClickListeners() {
        binding.closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}