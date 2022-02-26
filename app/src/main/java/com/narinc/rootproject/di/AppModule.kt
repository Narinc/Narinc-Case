package com.narinc.rootproject.di

import com.narinc.rootproject.core.initializer.InitializerDispatcher
import com.narinc.rootproject.core.initializer.InitializerDispatcherImp
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
