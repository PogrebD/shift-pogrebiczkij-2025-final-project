package com.pogreb.loan_details.data.converter

import com.pogreb.loan_details.data.model.LoanDetailsModel
import com.pogreb.loan_details.domain.entity.LoanDetails
import javax.inject.Inject

class LoanDetailsModelConverter @Inject constructor() {
    fun convertFromLoanDetailsModel(model: LoanDetailsModel): LoanDetails =
        LoanDetails(
            amount = model.amount.toLong(),
            date = model.date,
            name = model.name,
            id = model.id,
            lastName = model.lastName,
            percent = model.percent,
            period = model.period,
            phone = model.phone,
            status = model.status,
        )
}