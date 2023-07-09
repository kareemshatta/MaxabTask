package com.kareem.maxabtask.di

import com.kareem.domain.models.MovieVM
import com.kareem.domain.useCases.GetNowPlayingMoviesUseCase
import com.kareem.domain.useCases.UseCase
import com.kareem.maxabtask.BuildConfig
import com.kareem.maxabtask.ui.recent_screen.RecentViewModel
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
    @Named("ApiAccessToken")
    fun provideApiAccessToken() = BuildConfig.ApiAccessToken

}