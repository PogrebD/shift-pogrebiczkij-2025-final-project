package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.usecase

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.repository.AuthorizationRepository
import javax.inject.Inject

class CheckAlreadyLoggedUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) : suspend () -> Boolean by repository::alreadyLogged