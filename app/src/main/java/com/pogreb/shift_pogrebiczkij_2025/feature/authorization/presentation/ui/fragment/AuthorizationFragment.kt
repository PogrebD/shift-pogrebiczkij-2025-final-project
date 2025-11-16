package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pogreb.shift_pogrebiczkij_2025.databinding.FragmentAuthorizationBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.compose.AuthorizationScreen
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.viewmodel.AuthorizationViewModel
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.viewmodel.AuthorizationViewModelFactory
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import javax.inject.Inject

class AuthorizationFragment : Fragment() {

    @Inject
    lateinit var factory: AuthorizationViewModelFactory

    private lateinit var binding: FragmentAuthorizationBinding

    private val viewModel: AuthorizationViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as AuthorizationComponentProvider

        val studentsListComponent = provider.provideAuthorizationComponent()
        studentsListComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.authorizationComposeView.apply {
            setContent {
                AppTheme {
                    AuthorizationScreen(
                    )
                }
            }
        }
    }
}