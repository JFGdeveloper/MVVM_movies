package com.javidev.mvvm_movies_compose.ui.components

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.javidev.mvvm_movies_compose.R

@Composable
fun MyScaffold(content: @Composable ()-> Unit) {
    Scaffold( 
        topBar = { MyTopAppBar()}
    ) {
        content()
    }
}

@Composable
fun MyTopAppBar() {
    TopAppBar( 
        title = {Text(text = stringResource(id = R.string.app_name))}

    )
}