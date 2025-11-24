package com.pogreb.authorization.domain.usecase

import com.pogreb.authorization.domain.entity.AuthorizationData
import com.pogreb.authorization.domain.repository.AuthorizationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) : suspend (AuthorizationData) -> Boolean by repository::login