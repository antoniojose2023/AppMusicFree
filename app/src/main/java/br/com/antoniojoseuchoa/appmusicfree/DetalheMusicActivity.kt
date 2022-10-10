package br.com.antoniojoseuchoa.appmusicfree

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import br.com.antoniojoseuchoa.appmusicfree.databinding.ActivityDetalheMusicBinding
import br.com.antoniojoseuchoa.appmusicfree.domain.Musica

class DetalheMusicActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetalheMusicBinding.inflate(layoutInflater) }
    private lateinit var url_audio: String
    private lateinit var mediaPlayer: MediaPlayer
    private  var toque = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar!!.title = "Música"

        recoverMusic()

        binding.btPlay.setOnClickListener {
                startAudio()
        }

        binding.btPause.setOnClickListener {
            pauseAudio()
        }

        binding.btStop.setOnClickListener {
            toque = true
            stopAudio()

        }
    }

    fun startAudio(){
        mediaPlayer.start()
    }

    fun pauseAudio(){
        mediaPlayer.pause()
    }

    fun stopAudio(){
        mediaPlayer.stop()

        if(toque){
            recoverMusic()
        }
    }

    fun recoverMusic(){
        val intent = intent.getSerializableExtra("music") as Musica
        binding.tvNomeMusic.text = intent.nome

        url_audio = intent.url_audio
        val uri_audio = Uri.parse( url_audio )
        mediaPlayer = MediaPlayer.create(this, uri_audio)
    }

}