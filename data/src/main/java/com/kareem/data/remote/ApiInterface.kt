package com.kareem.data.remote

import com.kareem.data.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language")
        language: String = "en",
        @Query("page")
        pageNumber: Int = 1
    ): Response<MoviesResponse>
}