package com.kareem.data.repositories_imp

import com.kareem.data.remote.ApiInterface
import com.kareem.domain.models.MovieVM
import com.kareem.domain.repositories.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(private val service: ApiInterface) : MoviesRepository {

    override suspend fun getNowPlayingMovies(page: Int): MutableList<MovieVM>? =
        service.getNowPlayingMovies(pageNumber = page).body()?.results
            ?.map { it.map(it) }?.toMutableList()
}