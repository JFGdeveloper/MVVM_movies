package com.javidev.mvvm_movies_compose.dataLayer.api

import com.javidev.mvvm_movies_compose.dataLayer.common.Constants
import okhttp3.Interceptor
import okhttp3.Response

class MovieDbInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        // intercetamos la request y añadimos parametro
        val urlWithParam = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(Constants.URL_PARAM_APIKEY,Constants.API_KEY)
            .addQueryParameter(Constants.URL_PARAM_LANGUAGE,"es-ES")
            .build()

        // lanzamos el nuevo valor
        var request = chain.request()
        request = request.newBuilder()
            .url(urlWithParam)
            .addHeader("Content-Type","application/json")
            .addHeader("Accept","application/json")
            .build()

        return  chain.proceed(request)
    }

}

// usa este interceptor en el contenedor