package com.pogreb.authorization.domain.usecase

import com.pogreb.authorization.domain.repository.AuthorizationRepository
import javax.inject.Inject

class CheckAlreadyLoggedUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) : suspend () -> Boolean by repository::alreadyLogged