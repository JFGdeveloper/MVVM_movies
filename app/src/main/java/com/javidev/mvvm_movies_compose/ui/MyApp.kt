package com.javidev.mvvm_movies_compose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.javidev.mvvm_movies_compose.ui.homeScreen.HomeScreen
import com.javidev.mvvm_movies_compose.ui.homeScreen.HomeViewModel
import com.javidev.mvvm_movies_compose.ui.theme.MVVM_movies_composeTheme

@ExperimentalFoundationApi
@Composable
fun MyApp(viewModel: HomeViewModel) {
    MVVM_movies_composeTheme {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen(viewModel)

        }
    }

}

@ExperimentalFoundationApi
@Preview
@Composable
fun preMyApp() {
    MyApp(HomeViewModel())
}