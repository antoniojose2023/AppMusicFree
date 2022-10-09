package br.com.antoniojoseuchoa.appmusicfree.domain

import java.io.Serializable

data class Musica (
    val idMusic: String,
    val nome: String,
    val url_audio: String
): Serializable
