package com.javidev.mvvm_movies_compose.dataLayer.api

import com.javidev.mvvm_movies_compose.dataLayer.api.response.PopularMovieResponse
import retrofit2.Response
import retrofit2.http.GET


// ESTO LO TINES QUE INSTANCIAR Y PARA ESO USO UN CONTENEDOR
// QUE SERA LA CLASE CONTAINER

interface PopularMovieService_ {
    @GET("movie/popular")
    suspend fun getPopularMovieService(): Response<PopularMovieResponse>

}