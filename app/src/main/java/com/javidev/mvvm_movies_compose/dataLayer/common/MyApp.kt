package com.javidev.mvvm_movies_compose.dataLayer.common

import android.app.Application
import com.javidev.mvvm_movies_compose.dataLayer.api.NetworkContainer

// esto genera una instancia para toda la app
// en especial para los sitios que me falta un context

class MyApp: Application() {
    companion object{
        lateinit var instancia: MyApp
        val networkContainer = NetworkContainer() // la instancio para toda la app
    }

    override fun onCreate() {
        super.onCreate()
        instancia = this
    }
}

