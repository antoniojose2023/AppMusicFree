package br.com.antoniojoseuchoa.appmusicfree.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.antoniojoseuchoa.appmusicfree.ListMusicActivity
import br.com.antoniojoseuchoa.appmusicfree.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.appmusicfree.databinding.ItemDialogBinding
import br.com.antoniojoseuchoa.appmusicfree.domain.Playlist
import br.com.antoniojoseuchoa.appmusicfree.viewmodel.ViewModelMain

class MainActivity : AppCompatActivity(), AdapterMusic.OnClickPlaylistListener {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModelMain by viewModels<ViewModelMain>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showDialog()

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
                    val adapterMusic = AdapterMusic(this, states.list, this)
                    binding.rvPlaylist.adapter = adapterMusic
                }
            }
        }

    }

    override fun onClickPlaylist(playlist: Playlist) {
            val intent = Intent(this, ListMusicActivity::class.java)
            intent.putExtra("playlist", playlist)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    fun showDialog(){
           val view = ItemDialogBinding.inflate(layoutInflater)

           val alertDialog = AlertDialog.Builder(this)
           alertDialog.setView(view.root)
           alertDialog.setCancelable(false)
           alertDialog.setPositiveButton("Vamos lá escolha seu ritmo :)"){x, y ->}
           alertDialog.create()

           alertDialog.show()
    }

}