package com.narinc.challenge.di

import android.content.Context
import com.narinc.challenge.cache.UserCacheImpl
import com.narinc.challenge.cache.dao.UserDao
import com.narinc.challenge.cache.database.AppDatabase
import com.narinc.challenge.data.repository.UserCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideUserDao(
        database: AppDatabase
    ): UserDao = database.userDao()

    @Provides
    @Singleton
    fun provideUserCache(
        userCache: UserCacheImpl
    ): UserCache = userCache
}
