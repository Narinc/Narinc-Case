package com.narinc.challenge.di

import com.narinc.challenge.BuildConfig
import com.narinc.challenge.remote.api.AppService
import com.narinc.challenge.remote.api.ServiceFactory
import com.narinc.challenge.remote.repository.HomePageRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideService(): AppService =
        ServiceFactory.create(BuildConfig.DEBUG, BuildConfig.BASE_URL)

    @Provides
    @Singleton
    fun provideHomePageRemote(remote: HomePageRemoteImpl) = remote
}
