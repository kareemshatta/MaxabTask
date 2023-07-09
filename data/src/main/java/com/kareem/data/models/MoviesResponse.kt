package com.kareem.data.models

data class MoviesResponse(
    val results: List<Movie>,
    val page: Int
)