package com.kareem.domain.repositories

import com.kareem.domain.models.MovieVM


interface MoviesRepository {
   suspend fun getNowPlayingMovies(page: Int): MutableList<MovieVM>?
}