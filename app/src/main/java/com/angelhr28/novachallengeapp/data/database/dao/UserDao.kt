package com.angelhr28.novachallengeapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.angelhr28.novachallengeapp.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Transaction
    suspend fun save(data: User) {
        deleteAll()
        insert(data)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("DELETE FROM users")
    suspend fun deleteAll()

    @Query("SELECT * FROM users LIMIT 1")
    fun getUser(): Flow<User>
}