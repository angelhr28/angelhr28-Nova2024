package com.angelhr28.novachallengeapp.domain.usecase.login

import com.angelhr28.novachallengeapp.data.model.User
import com.angelhr28.novachallengeapp.data.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: LoginRepository
) {

    suspend fun invoke(user: User) = userRepository.login(user)

}