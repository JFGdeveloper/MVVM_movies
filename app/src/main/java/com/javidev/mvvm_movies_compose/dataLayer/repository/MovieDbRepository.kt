package com.javidev.mvvm_movies_compose.dataLayer.repository

import com.javidev.mvvm_movies_compose.dataLayer.common.MyApp


class MovieDbRepository {
    private val movieDbService = MyApp.networkContainer.popularMoviService

    suspend fun getPopularMovie() = movieDbService.getPopularMovieService()
}