package br.com.antoniojoseuchoa.appmusicfree.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RepositoryPlaylist {

    companion object{
        val url_base = "https://antoniojose2023.github.io/"

        val retrofit = Retrofit.Builder()
            .baseUrl( url_base )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create( Api::class.java )
    }
}