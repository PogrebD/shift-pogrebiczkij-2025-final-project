package com.pogreb.authorization.domain.usecase

import com.pogreb.authorization.domain.entity.AuthorizationData
import com.pogreb.authorization.domain.repository.AuthorizationRepository
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) : suspend (AuthorizationData) -> Unit by repository::register