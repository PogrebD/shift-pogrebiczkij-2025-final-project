package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.usecase

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.repository.AuthorizationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) : suspend (AuthorizationData) -> String by repository::login