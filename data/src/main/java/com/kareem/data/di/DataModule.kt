package com.kareem.data.di

import com.kareem.data.remote.ApiInterface
import com.kareem.data.remote.NetworkInterceptor
import com.kareem.data.repositories_imp.MoviesRepositoryImp
import com.kareem.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(@Named("BaseUrl") baseUrl: String, networkInterceptor: NetworkInterceptor): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(networkInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideNetworkInterceptor(@Named("ApiAccessToken") token: String) = NetworkInterceptor(token)

    @Provides
    @Singleton
    fun provideMoviesRepository(service: ApiInterface): MoviesRepository = MoviesRepositoryImp(service)
}
