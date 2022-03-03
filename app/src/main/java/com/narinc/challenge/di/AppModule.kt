package com.narinc.challenge.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.narinc.challenge.R
import com.narinc.challenge.core.initializer.InitializerDispatcher
import com.narinc.challenge.core.initializer.InitializerDispatcherImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerInitializerDispatcher(): InitializerDispatcher = InitializerDispatcherImp()

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_baseline_terrain_24)
            .error(R.drawable.ic_baseline_error_outline_64)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )
}
