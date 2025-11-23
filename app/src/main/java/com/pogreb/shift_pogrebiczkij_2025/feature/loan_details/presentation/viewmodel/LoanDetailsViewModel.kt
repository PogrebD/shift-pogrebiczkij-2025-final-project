package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.usecase.GetLoanDetailsUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.state.LoanDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

class LoanDetailsViewModel @Inject constructor(
    private val getLoanDetailsUseCase: GetLoanDetailsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<LoanDetailsState>(LoanDetailsState.Initialize)
    val state: StateFlow<LoanDetailsState> = _state.asStateFlow()

    fun initialize(id: Long) {
        loadData(id)
    }

    fun refresh(id: Long) {
        loadData(id)
    }

    private fun loadData(id: Long) {
        _state.update { LoanDetailsState.Loading }

        viewModelScope.launch {
            try {
                val loanDetails = getLoanDetailsUseCase(id)
                val formattedDate = formatDate(loanDetails.date)
                _state.update {
                    LoanDetailsState.Content(
                        loanDetails = loanDetails.copy(date = formattedDate)
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    LoanDetailsState.Error(
                        massage = e.message ?: ""
                    )
                }
            }
        }
    }

    fun clearDialog() {
        _state.update {
            LoanDetailsState.Loading
        }
    }

    private fun formatDate(isoDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        val date = inputFormat.parse(isoDate)
        return date?.let { outputFormat.format(it) } ?: ""
    }
}