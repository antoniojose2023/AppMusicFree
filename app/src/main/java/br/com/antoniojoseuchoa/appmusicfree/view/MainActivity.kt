package br.com.antoniojoseuchoa.appmusicfree.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.antoniojoseuchoa.appmusicfree.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.appmusicfree.viewmodel.ViewModelMain

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModelMain by viewModels<ViewModelMain>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar!!.title = "Music Free"
        viewModelMain.getListPlaylist()

    }

    override fun onResume() {
        super.onResume()
        viewModelMain.playlist.observe(this){ states ->
            when(states){
                ViewModelMain.States.loader -> {

                }
                is ViewModelMain.States.Erro -> {
                    Toast.makeText(this, "Error ${states.mensagem}", Toast.LENGTH_LONG).show()
                }
                is ViewModelMain.States.OnSucess -> {
                    binding.rvPlaylist.layoutManager = LinearLayoutManager(this)
                    val adapterMusic = AdapterMusic(this, states.list)
                    binding.rvPlaylist.adapter = adapterMusic
                }
            }
        }

    }
}