package com.javidev.mvvm_movies_compose.dataLayer.api

import com.javidev.mvvm_movies_compose.dataLayer.common.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// esta clase tiene que instanciar la interface
// y para que sea un singleton la instancio en MyApp

class NetworkContainer {

    // usamos el interceptor
    private val movieDbInterceptor = MovieDbInterceptor()
    private val okHttpClient: OkHttpClient = with(OkHttpClient.Builder()){
        addInterceptor(movieDbInterceptor)
        build()
    }

    val popularMoviService: PopularMovieService_ = Retrofit.Builder()
        .baseUrl(Constants.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient) // esto usara mi interceptor
        .build()
        .create(PopularMovieService_::class.java)

}