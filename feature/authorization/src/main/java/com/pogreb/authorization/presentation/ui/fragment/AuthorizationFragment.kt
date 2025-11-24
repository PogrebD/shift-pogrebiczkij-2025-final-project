package com.pogreb.authorization.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pogreb.authorization.databinding.FragmentAuthorizationBinding
import com.pogreb.authorization.di.AuthorizationComponentProvider
import com.pogreb.authorization.presentation.AuthorizationRouter
import com.pogreb.authorization.presentation.ui.compose.AuthorizationScreen
import com.pogreb.authorization.presentation.viewmodel.AuthorizationViewModel
import com.pogreb.authorization.presentation.viewmodel.AuthorizationViewModelFactory
import com.pogreb.design.theme.AppTheme
import javax.inject.Inject

class AuthorizationFragment : Fragment() {

    companion object {
        fun newInstance(): AuthorizationFragment {
            return AuthorizationFragment()
        }
    }

    @Inject
    lateinit var factory: AuthorizationViewModelFactory

    @Inject
    lateinit var router: AuthorizationRouter

    private lateinit var binding: FragmentAuthorizationBinding

    private val viewModel: AuthorizationViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val provider = requireActivity() as AuthorizationComponentProvider

        val authorizationComponent = provider.provideAuthorizationComponent()
        authorizationComponent.inject(this)

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
                        viewModel = viewModel,
                        onLoginClick = {
                            router.openMainPage(parentFragmentManager)
                        },
                        onRegistrationClick = {
                            router.openOnboarding(parentFragmentManager)
                        },
                    )
                }
            }
        }
    }
}