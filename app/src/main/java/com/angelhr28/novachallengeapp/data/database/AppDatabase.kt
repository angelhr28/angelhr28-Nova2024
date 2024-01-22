package com.angelhr28.novachallengeapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angelhr28.novachallengeapp.data.database.dao.UserDao
import com.angelhr28.novachallengeapp.data.model.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}