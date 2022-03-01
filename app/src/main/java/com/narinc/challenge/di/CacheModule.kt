package com.narinc.challenge.di

import android.content.Context
import com.narinc.challenge.HomePageCacheImpl
import com.narinc.challenge.cache.UserCacheImpl
import com.narinc.challenge.cache.dao.HomePageDao
import com.narinc.challenge.cache.dao.UserDao
import com.narinc.challenge.cache.database.AppDatabase
import com.narinc.challenge.cache.utils.CachePreferencesHelper
import com.narinc.challenge.data.repository.HomePageCache
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

    @Provides
    @Singleton
    fun provideHomePageDao(
        database: AppDatabase
    ): HomePageDao = database.homePageDao()

    @Provides
    @Singleton
    fun provideHomePageCache(
        cache: HomePageCacheImpl
    ): HomePageCache = cache

    @Provides
    @Singleton
    fun providePreferenceHelper(@ApplicationContext context: Context): CachePreferencesHelper =
        CachePreferencesHelper(context)
}
