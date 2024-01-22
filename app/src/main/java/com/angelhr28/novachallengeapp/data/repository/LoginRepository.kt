package com.angelhr28.novachallengeapp.data.repository

import com.angelhr28.novachallengeapp.data.database.dao.UserDao
import com.angelhr28.novachallengeapp.data.model.User
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val dao: UserDao
) {

    suspend fun login(user: User) = dao.save(user)

}