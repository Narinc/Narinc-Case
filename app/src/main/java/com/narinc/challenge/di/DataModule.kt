package com.narinc.challenge.di

import com.narinc.challenge.data.HomePageRepositoryImpl
import com.narinc.challenge.data.UserRepositoryImpl
import com.narinc.challenge.domain.repository.HomePageRepository
import com.narinc.challenge.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideUserRepository(
        repository: UserRepositoryImpl
    ): UserRepository = repository

    @Provides
    @Singleton
    fun provideHomePageRepository(
        repository: HomePageRepositoryImpl
    ): HomePageRepository = repository
}
