package com.javidev.mvvm_movies_compose.ui.homeScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.mvvm_movies_compose.dataLayer.api.response.Movie
import com.javidev.mvvm_movies_compose.dataLayer.api.response.PopularMoviesResponse
import com.javidev.mvvm_movies_compose.dataLayer.common.MyApp
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {
    // REPOSITORY creando una instancia de mi singleton
    private val movieDbRepository = MyApp.networkContainer.popularMoviService

    // LLAMADA A LA API////////

    private var _popularMovies = MutableLiveData<Response<PopularMoviesResponse>>()
    var movies: LiveData<Response<PopularMoviesResponse>> = _popularMovies


    // FORMA NUEVA DE COMPOSE///////
    var moviesState = mutableStateListOf<Movie>()
        private set



    init {
        addMovies()
    }

    fun addMovies() = viewModelScope.launch {
        val populars = movieDbRepository.getPopularMovieService().body()?.results
        moviesState.addAll(populars!!)
    }


    fun getPopularMovies(): List<Movie> {
        val movies: SnapshotStateList<Movie> = moviesState
        return movies
    }


}