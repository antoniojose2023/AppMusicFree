package br.com.antoniojoseuchoa.appmusicfree.data

import br.com.antoniojoseuchoa.appmusicfree.domain.Music
import retrofit2.Call
import retrofit2.http.GET

interface Api {
       @GET("apimusic/playlist.json")
       fun getPlaylist(): Call<Music>
}