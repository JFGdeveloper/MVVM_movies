package com.javidev.mvvm_movies_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.javidev.mvvm_movies_compose.ui.homeScreen.HomeViewModel
import com.javidev.mvvm_movies_compose.ui.theme.MVVM_movies_composeTheme
import java.security.acl.Owner

class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MVVM_movies_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    muestraLog(viewmodel = viewmodel)
                    Greeting("Android", viewmodel = viewmodel)
                }
            }



        }
    }


}


@Composable
private fun muestraLog(viewmodel: HomeViewModel) {

    val viewModel = viewmodel.getPopularMovies()
    Log.i("javi", "/////////hola javier eres el mejor/////////")
    Log.i("javi", "////////peli elegida es: $viewModel")
}

@Composable
fun Greeting(name: String,viewmodel: HomeViewModel) {

    val movies = viewmodel.getPopularMovies()
    // println(movies.message() ?: "es nulo el value de moviessssssssssssss")

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Hello $name!")
        Text(text = "Hello ${movies[0] }")
        Text(text = "Hello $name!")
        Text(text = "Hello $name!")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVM_movies_composeTheme {
        //Greeting("Android")
    }
}