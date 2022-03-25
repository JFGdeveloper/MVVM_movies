package com.javidev.mvvm_movies_compose.ui.homeScreen

import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.mvvm_movies_compose.dataLayer.api.response.PopularMovieResponse
import com.javidev.mvvm_movies_compose.dataLayer.repository.MovieDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel: ViewModel() {
    // REPOSITORY
    private val movieDbRepository = MovieDbRepository()

    // LLAMADA A LA API////////
    private var _popularMovies: MutableLiveData<Response<PopularMovieResponse>> = MutableLiveData()
    var popularMovies: LiveData<Response<PopularMovieResponse>> = _popularMovies

    // FORMA NUEVA DE COMPOSE///////
    var popularMoviesState = mutableStateListOf<PopularMovieResponse>()
    private set

    init {
        getPopularMovies()
    }

    fun getPopularMovies() = viewModelScope.launch(Dispatchers.IO){
        _popularMovies.value = movieDbRepository.getPopularMovie()
    }


}