package br.com.antoniojoseuchoa.appmusicfree.domain

data class Playlist (
    val id: String,
    val categoria: String,
    val url: String,
    val musicas: List<Musica>
)