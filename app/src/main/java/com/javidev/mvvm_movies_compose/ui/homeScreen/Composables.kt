package com.javidev.mvvm_movies_compose.ui.homeScreen

import android.view.RoundedCorner
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.transform.CircleCropTransformation
import com.javidev.mvvm_movies_compose.dataLayer.api.response.Movie
import com.javidev.mvvm_movies_compose.dataLayer.common.Constants


@ExperimentalFoundationApi
@Composable
fun ListaMovies(movies: List<Movie>) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
        cells = GridCells.Adaptive(200.dp)
    ) {
        items(movies) { movie ->
            ItemMovie(movie)
        }
    }
}

@Composable
fun ItemMovie(movie: Movie) {

    Card(
        modifier = Modifier.padding(5.dp),
        shape = RoundedCornerShape(10),
        border = BorderStroke(1.dp, MaterialTheme.colors.primary)
    ) {
        Column {
            ImagenPuntuacion(movie)//box

            FechaDescription(movie)
        }/// colum
    }
}

@Composable
private fun ImagenPuntuacion(movie: Movie) {
    Box(
        contentAlignment = Alignment.BottomEnd
    ) {
        AsyncImage(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = Constants.IMAGE_BASE_URL + movie.poster_path,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )

        Puntuacion(movie)
    }
}

@Composable
private fun FechaDescription(movie: Movie) {
    Box(
        modifier =
        Modifier
            .size(width = 200.dp, height = 90.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = movie.release_date)
            Text(text = movie.overview, overflow = TextOverflow.Clip)
        }
    }
}

@Composable
private fun Puntuacion(movie: Movie) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 5.dp
                )
            )
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    )
    {
        Text(text = movie.vote_average.toString())
    }
}

/////////////// PREVIEW //////////////////////////////

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun preLazy() {
    val listnumber = listOf(1, 2, 4, 2, 2, 2)
    val list = listOf(
        Movie(
            true,
            "javi",
            listnumber,
            45,
            "españos",
            "over",
            "",
            90.0,
            "ksksksk",
            "release",
            "title",
            false,
            45.9,
            45
        ),
        Movie(
            true,
            "javi",
            listnumber,
            45,
            "españos",
            "over",
            "",
            90.0,
            "ksksksk",
            "release",
            "title",
            false,
            45.9,
            45
        )

    )
    ListaMovies(movies = list)
}

@Preview
@Composable
fun preCelda() {
    val list = listOf(1, 2, 3, 4, 5, 6, 6)
    val movie = Movie(
        true,
        "javi",
        list,
        45,
        "españos",
        "over",
        "",
        90.0,
        "ksksksk",
        "release",
        "title",
        false,
        45.9,
        45

    )

    ItemMovie(movie = movie)

}