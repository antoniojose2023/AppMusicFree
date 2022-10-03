package br.com.antoniojoseuchoa.appmusicfree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.antoniojoseuchoa.appmusicfree.databinding.ActivityListMusicBinding
import br.com.antoniojoseuchoa.appmusicfree.domain.Musica
import br.com.antoniojoseuchoa.appmusicfree.domain.Playlist
import br.com.antoniojoseuchoa.appmusicfree.view.AdapterMusic

class ListMusicActivity : AppCompatActivity(), AdapterMusic.OnClickMusicListener {
    private val binding by lazy { ActivityListMusicBinding.inflate(layoutInflater) }
    private var list = mutableListOf<Musica>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = getIntent().getSerializableExtra("playlist") as Playlist
        list = intent.musicas as MutableList<Musica>

        binding.rvMusic.layoutManager = LinearLayoutManager(this)
        val adapterMusic = AdapterMusic(this, list, this)
        binding.rvMusic.adapter = adapterMusic

    }

    override fun onClickMusic(music: Musica) {
        
    }
}