package com.kareem.data.models

import com.kareem.domain.mapper.Mapper
import com.kareem.domain.models.MovieVM

data class Movie(
    val id: String?,
    val backdrop_path: String?,
    val title: String?,
    val vote_average: Double?,
) : Mapper<Movie, MovieVM> {

    override fun map(from: Movie): MovieVM = MovieVM(
        id = id ?: "",
        url = "https://image.tmdb.org/t/p/w780$backdrop_path",
        title = title ?: "",
        vote = vote_average ?: 0.0,
    )
}