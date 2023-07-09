package com.kareem.maxabtask.di

import com.kareem.maxabtask.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @Named("BaseUrl")
    fun provideBaseUrl() = BuildConfig.BaseUrl

    @Provides
    @Singleton
    @Named("BaseUrl")
    fun provideApiAccessToken() = BuildConfig.BaseUrl
}