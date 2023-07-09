package com.kareem.domain.di

import com.kareem.domain.repositories.MoviesRepository
import com.kareem.domain.useCases.GetNowPlayingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideNowPlayingMoviesUseCase(repository: MoviesRepository) = GetNowPlayingMoviesUseCase(repository)
}