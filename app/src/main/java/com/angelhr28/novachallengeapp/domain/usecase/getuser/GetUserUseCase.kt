package com.angelhr28.novachallengeapp.domain.usecase.getuser

import com.angelhr28.novachallengeapp.data.repository.GetUserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val getUserRepository: GetUserRepository
) {

    fun invoke() = getUserRepository.getUser()

}