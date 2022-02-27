package com.narinc.challenge.di

import com.narinc.challenge.core.initializer.InitializerDispatcher
import com.narinc.challenge.core.initializer.InitializerDispatcherImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerInitializerDispatcher(): InitializerDispatcher = InitializerDispatcherImp()
}
