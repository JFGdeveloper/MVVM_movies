package com.javidev.mvvm_movies_compose.dataLayer.common.response

data class PopularMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
