package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.converter

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.entity.LoanRequest
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.UserData
import javax.inject.Inject

class LoanRequestConverter @Inject constructor() {
    fun convertToLoanRequest(
        loanData: LoanData,
        userData: UserData
    ): LoanRequest =
        LoanRequest(
            amount = loanData.amount,
            firstName = userData.name,
            lastName = userData.lastName,
            percent = loanData.percent,
            period = loanData.period,
            phone = userData.phone,
        )

}