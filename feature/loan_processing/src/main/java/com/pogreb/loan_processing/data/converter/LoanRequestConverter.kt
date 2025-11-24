package com.pogreb.loan_processing.data.converter

import com.pogreb.loan_processing.data.model.LoanRequest
import com.pogreb.loan_processing.domain.entity.LoanData
import com.pogreb.loan_processing.domain.entity.UserData
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