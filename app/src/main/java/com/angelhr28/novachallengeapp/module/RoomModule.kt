package com.angelhr28.novachallengeapp.module

import android.content.Context
import androidx.room.Room
import com.angelhr28.novachallengeapp.data.database.AppDatabase
import com.angelhr28.novachallengeapp.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DATABASE_NAME = "nova.db"

    @Singleton
    @Provides
    fun provideNovaDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideRecipeDao(db: AppDatabase): UserDao = db.userDao()
}
