package com.angelhr28.novachallengeapp.domain.usecase.logout

import com.angelhr28.novachallengeapp.data.repository.LogoutRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val logoutRepository: LogoutRepository
) {

    suspend fun invoke() = logoutRepository.logout()

}