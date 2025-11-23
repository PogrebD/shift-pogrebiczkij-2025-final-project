package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.usecase.GetLoansUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.state.LoanHistoryState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoanHistoryViewModel @Inject constructor(
    private val getLoansUseCase: GetLoansUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<LoanHistoryState>(LoanHistoryState.Initialize)
    val state: StateFlow<LoanHistoryState> = _state.asStateFlow()

    fun initialize() {
        if (_state.value is LoanHistoryState.Content) return

        _state.update {
            LoanHistoryState.Loading
        }

        viewModelScope.launch {
            try {
                val loans = getLoansUseCase()
                _state.update {
                    LoanHistoryState.Content(
                        loans = loans,
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    LoanHistoryState.Content(
                        loans = emptyList(),
                        errorMassage = e.message ?: "",
                    )
                }
            }
        }
    }

    fun refresh() {
        val currentState = _state.value as LoanHistoryState.Content
        _state.update {
            currentState.copy(
                isRefreshing = true,
                errorMassage = "",
            )
        }
        viewModelScope.launch {
            try {
                val loans = getLoansUseCase()
                _state.update {
                    LoanHistoryState.Content(
                        loans = loans,
                        isRefreshing = false,
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    currentState.copy(
                        isRefreshing = false,
                        errorMassage = e.message ?: "",
                    )
                }
            }
        }
    }

    fun clearDialog() {
        _state.update {
            LoanHistoryState.Content(
                loans = emptyList(),
                isRefreshing = false,
                errorMassage = "",
            )
        }
    }
}