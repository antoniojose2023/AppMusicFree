package br.com.antoniojoseuchoa.appmusicfree.domain

import java.io.Serializable

data class Music (
    val playlist: List<Playlist>
): Serializable