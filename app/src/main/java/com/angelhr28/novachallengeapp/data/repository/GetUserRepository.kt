package com.angelhr28.novachallengeapp.data.repository

import com.angelhr28.novachallengeapp.data.database.dao.UserDao
import javax.inject.Inject

class GetUserRepository @Inject constructor(
    private val dao: UserDao
) {

    fun getUser() = dao.getUser()

}