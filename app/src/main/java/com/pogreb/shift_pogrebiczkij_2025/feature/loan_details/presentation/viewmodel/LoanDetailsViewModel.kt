package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.usecase.GetLoanDetailsUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.state.LoanDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoanDetailsViewModel @Inject constructor(
    private val getLoanDetailsUseCase: GetLoanDetailsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<LoanDetailsState>(LoanDetailsState.Initialize)
    val state: StateFlow<LoanDetailsState> = _state.asStateFlow()

    fun initialize(id: Long) {
        _state.update { LoanDetailsState.Loading }

        viewModelScope.launch {
            try {
                val loanDetails = getLoanDetailsUseCase(id)
                _state.update {
                    LoanDetailsState.Content(
                        loanDetails = loanDetails
                    )
                }
            } catch (e: Exception) {
                Log.e("loans", e.message ?: "")
            }
        }
    }
}