package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.data.converter

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.data.model.LoanModel
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan
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