package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.LoanConditions
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.usecase.GetLoanConditionsUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.usecase.GetRecentLoansUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.state.MainPageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPageViewModel @Inject constructor(
    private val getLoanConditionsUseCase: GetLoanConditionsUseCase,
    private val getRecentLoansUseCase: GetRecentLoansUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<MainPageState>(MainPageState.Initialize)
    val state: StateFlow<MainPageState> = _state.asStateFlow()

    fun initialize() {
        _state.update { MainPageState.Loading }

        var currentState = MainPageState.Content(
            loanConditions = LoanConditions(
                percent = 0.0,
                period = 0,
                maxAmount = 0,
            ),
            errorTextConditions = "",
            loans = emptyList(),
            errorTextLoans = "",
            loanAmount = 0,
        )

        viewModelScope.launch {
            try {
                val loanConditions = getLoanConditionsUseCase()
                currentState = currentState.copy(
                    loanConditions = loanConditions,
                    loanAmount = ((loanConditions.maxAmount * 0.7).toLong()), //!!!!!
                )

                _state.update {
                    currentState
                }
            } catch (e: Exception) {
                currentState = currentState.copy(
                    errorTextConditions = e.message ?: ""
                )

                _state.update {
                    currentState.copy(
                        errorTextConditions = e.message ?: ""
                    )
                }
            }

            try {
                val loans = getRecentLoansUseCase()
                currentState = currentState.copy(
                    loans = loans,
                )

                _state.update {
                    currentState
                }
            } catch (e: Exception) {
                currentState = currentState.copy(
                    errorTextLoans = e.message ?: ""
                )

                _state.update {
                    currentState
                }
            }
        }
    }

    fun refreshLoanCondition() {
        val currentState = _state.value as MainPageState.Content

        viewModelScope.launch {
            try {
                val loanConditions = getLoanConditionsUseCase()

                _state.update {
                    currentState.copy(
                        loanConditions = loanConditions,
                        loanAmount = ((loanConditions.maxAmount * 0.7).toLong()), //!!!!!
                        errorTextConditions = "",
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    currentState.copy(
                        errorTextConditions = e.message ?: ""
                    )
                }
            }
        }
    }

    fun refreshLoans() {
        val currentState = _state.value as MainPageState.Content

        viewModelScope.launch {
            try {
                val loans = getRecentLoansUseCase()

                _state.update {
                    currentState.copy(
                        loans = loans,
                        errorTextLoans = "",
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    currentState.copy(
                        errorTextLoans = e.message ?: ""
                    )
                }
            }
        }
    }

    fun updateLoanAmount(loanAmount: Float) {
        _state.update { currentState ->
            if (currentState is MainPageState.Content) {
                currentState.copy(
                    loanAmount = loanAmount.toLong()
                )
            } else currentState
        }
    }
}