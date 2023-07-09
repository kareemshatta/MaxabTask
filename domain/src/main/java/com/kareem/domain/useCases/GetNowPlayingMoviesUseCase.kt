package com.kareem.domain.useCases

import com.kareem.domain.models.MovieVM
import com.kareem.domain.repositories.MoviesRepository
import com.kareem.domain.result.Resource
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(private val repository: MoviesRepository) :
    UseCase<GetNowPlayingMoviesUseCase.Params, MutableList<MovieVM>?> {
    override suspend fun execute(params: Params): Resource<MutableList<MovieVM>?> {
        return try {
            val data = repository.getNowPlayingMovies(params.page)
            if (data == null)
                Resource.Error("empty data")
            else
                Resource.Success(data)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    data class Params(
        val page: Int = 1
    )
}