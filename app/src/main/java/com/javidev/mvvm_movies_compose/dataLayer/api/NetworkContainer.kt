package com.javidev.mvvm_movies_compose.dataLayer.api

import com.javidev.mvvm_movies_compose.dataLayer.common.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// esta clase tiene que instanciar la interface
// y para que sea un singleton la instancio en MyApp

class NetworkContainer {

    val popularMoviService: PopularMovieService_ = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.API_BASE_URL)
        .build()
        .create(PopularMovieService_::class.java)

}