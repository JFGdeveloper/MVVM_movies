package com.javidev.mvvm_movies_compose.dataLayer.common

import android.app.Application

// esto genera una instancia para toda la app
// en especial para los sitios que me falta un context

class MyApp: Application() {
    companion object{
        lateinit var instancia: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        instancia = this
    }
}

