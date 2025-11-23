package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.UserData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.usecase.CreateNewLoanUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.state.LoanProcessingState
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

class LoanProcessingViewModel @Inject constructor(
    private val createNewLoanUseCase: CreateNewLoanUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<LoanProcessingState>(LoanProcessingState.Initialize)
    val state: StateFlow<LoanProcessingState> = _state.asStateFlow()

    fun initialize(
        percent: Double,
        period: Int,
        amount: Long,
    ) {
        _state.update {
            LoanProcessingState.Content(
                loanData = LoanData(
                    percent = percent,
                    period = period,
                    amount = amount,
                ),
                userData = UserData(
                    name = "",
                    lastName = "",
                    phone = "",
                ),
                nameErrorType = InputErrorType.NONE,
                lastNameErrorType = InputErrorType.NONE,
                phoneErrorType = InputErrorType.NONE,
            )
        }
    }

    fun createLoan() {
        val currentState = _state.value as LoanProcessingState.Content
        viewModelScope.launch {
            try {
                val loanResult = createNewLoanUseCase(
                    currentState.loanData,
                    currentState.userData
                )
                if (loanResult.status == LoanStatus.REJECTED) {
                    _state.update {
                        LoanProcessingState.FailureResult
                    }
                } else {
                    val endDate =
                        formatDateWithAddedDays(loanResult.date, currentState.loanData.period)
                    _state.update {
                        LoanProcessingState.SuccessfulResult(
                            amount = currentState.loanData.amount,
                            date = endDate
                        )
                    }
                }
            } catch (e: Exception) {
                _state.update {
                    currentState.copy(errorMassage = e.message ?: "")
                }
            }
        }
    }

    fun refreshCreateLoan() {
        val currentState = _state.value as LoanProcessingState.Content
        _state.update {
            currentState.copy(errorMassage = "")
        }
        viewModelScope.launch {
            try {
                val loanResult = createNewLoanUseCase(
                    currentState.loanData,
                    currentState.userData
                )
                if (loanResult.status == LoanStatus.REJECTED) {
                    _state.update {
                        LoanProcessingState.FailureResult
                    }
                } else {
                    val endDate =
                        formatDateWithAddedDays(loanResult.date, currentState.loanData.period)
                    _state.update {
                        LoanProcessingState.SuccessfulResult(
                            amount = currentState.loanData.amount,
                            date = endDate
                        )
                    }
                }
            } catch (e: Exception) {
                _state.update {
                    currentState.copy(errorMassage = e.message ?: "")
                }
            }
        }
    }

    fun clearDialog() {
        val currentState = _state.value as LoanProcessingState.Content
        _state.update {
            currentState.copy(errorMassage = "")
        }
    }

    fun updateName(name: String) {
        val currentState = _state.value as? LoanProcessingState.Content ?: return
        var errorType = InputErrorType.NONE

        if (!validateName(name)) {
            errorType = InputErrorType.ONLY_RUSSIAN_LETTERS
        }
        _state.update {
            currentState.copy(
                userData = currentState.userData.copy(name = name),
                nameErrorType = errorType
            )
        }
    }

    fun updateLastName(lastName: String) {
        val currentState = _state.value as? LoanProcessingState.Content ?: return
        var errorType = InputErrorType.NONE

        if (!validateName(lastName)) {
            errorType = InputErrorType.ONLY_RUSSIAN_LETTERS
        }
        _state.update {
            currentState.copy(
                userData = currentState.userData.copy(lastName = lastName),
                nameErrorType = errorType
            )
        }
    }

    fun updatePhone(phone: String) {
        val currentState = _state.value as? LoanProcessingState.Content ?: return
        var errorType = InputErrorType.NONE

        val phoneDigitsOnly = phone.filter { it.isDigit() }
        if (phoneDigitsOnly.length <= 11) {
            if (!validatePhone(phone)) {
                errorType = InputErrorType.INVALID_PHONE_NUMBER
            }
            _state.update {
                currentState.copy(
                    userData = currentState.userData.copy(phone = phone),
                    phoneErrorType = errorType,
                )
            }
        }


    }

    private fun validateName(login: String): Boolean {
        val regex = Regex("^[а-яА-ЯёЁ]+$")
        return regex.matches(login)
    }

    private fun validatePhone(phone: String): Boolean {
        return if (phone.isNotEmpty()) {
            phone[0] == '7' || phone[0] == '8'
        } else false
    }

    private fun formatDateWithAddedDays(isoDate: String, daysToAdd: Int): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
        val outputFormat = SimpleDateFormat("d MMMM", Locale("ru"))

        val date = inputFormat.parse(isoDate)
        return if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.DAY_OF_MONTH, daysToAdd)
            outputFormat.format(calendar.time)
        } else {
            ""
        }
    }
}