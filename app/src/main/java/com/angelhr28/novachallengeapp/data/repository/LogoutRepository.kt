package com.angelhr28.novachallengeapp.data.repository

import com.angelhr28.novachallengeapp.data.database.dao.UserDao
import javax.inject.Inject

class LogoutRepository @Inject constructor(
    private val dao: UserDao
) {

    suspend fun logout() = dao.deleteAll()

}