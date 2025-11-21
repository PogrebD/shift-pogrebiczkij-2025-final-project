package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.data.converter

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.data.model.LoanModel
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity.Loan
import javax.inject.Inject

class LoanModelConverter @Inject constructor() {
    fun convertFromLoanModel(model: LoanModel): Loan =
        Loan(
            id = model.id,
            amount = model.amount.toLong(),
            status = model.status,
            date = model.date,
        )
}