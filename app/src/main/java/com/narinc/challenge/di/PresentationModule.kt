package com.narinc.challenge.di

import com.narinc.challenge.presenter.utils.CoroutineContextProvider
import com.narinc.challenge.presenter.utils.CoroutineContextProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    @Singleton
    fun provideCoroutineContextProvider(contextProvider: CoroutineContextProviderImpl): CoroutineContextProvider =
        contextProvider
}
