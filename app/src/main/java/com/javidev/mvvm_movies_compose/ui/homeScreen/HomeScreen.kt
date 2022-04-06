package com.javidev.mvvm_movies_compose.ui.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.javidev.mvvm_movies_compose.dataLayer.api.response.Movie
import com.javidev.mvvm_movies_compose.ui.components.MyScaffold

@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
   val movies = viewModel.getPopularMovies()

    MyScaffold(
       content = { ListaMovies(movies = movies) }
    )
}



@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun prevHome() {

    HomeScreen(HomeViewModel())
    //ejemCelda()
}
