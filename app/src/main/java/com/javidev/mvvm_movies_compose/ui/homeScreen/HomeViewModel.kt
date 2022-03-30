package com.javidev.mvvm_movies_compose.ui.homeScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.mvvm_movies_compose.dataLayer.api.response.PopularMoviesResponse
import com.javidev.mvvm_movies_compose.dataLayer.repository.MovieDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel: ViewModel() {
    // REPOSITORY
    private val movieDbRepository = MovieDbRepository()

    // LLAMADA A LA API////////
    private var _popularMovies = MutableLiveData<Response<PopularMoviesResponse>>()
    var popularMovies: LiveData<Response<PopularMoviesResponse>> = _popularMovies

    // FORMA NUEVA DE COMPOSE///////
    var popularMoviesState = mutableStateListOf<Response<PopularMoviesResponse>>()
    private set

    init {
        getPopularMovies()

        println("////////valor de popularmovies: ${popularMovies.value}")
        println("////////valor de popularmoviesState: ${popularMoviesState[0].body()!!.results[0]}")
    }

    @JvmName("getPopularMovies1")
    fun getPopularMovies(): SnapshotStateList<Response<PopularMoviesResponse>> {
        viewModelScope.launch(Dispatchers.IO) {
            //_popularMovies.postValue( movieDbRepository.getPopularMovie())
            val populars: Response<PopularMoviesResponse> = movieDbRepository.getPopularMovies()
            popularMoviesState.add(populars)
        }

        return popularMoviesState
    }


}