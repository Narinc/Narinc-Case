package com.narinc.challenge.di

import com.narinc.challenge.data.UserRepositoryImpl
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
        userRepository: UserRepositoryImpl
    ): UserRepository = userRepository
}
