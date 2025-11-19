package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

        viewModelScope.launch {
            try {
                val loanConditions = getLoanConditionsUseCase()
                val loans = getRecentLoansUseCase()
                _state.update {
                    MainPageState.Content(
                        loanConditions = loanConditions,
                        loans = loans,
                        loanAmount = ((loanConditions.maxAmount * 0.7).toLong()), //!!!!!
                    )
                }
            } catch (e: Exception) {
                Log.e("loans", e.message ?: "")
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