package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.usecase

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.User
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.repository.AuthorizationRepository
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) : suspend (AuthorizationData) -> User by repository::register