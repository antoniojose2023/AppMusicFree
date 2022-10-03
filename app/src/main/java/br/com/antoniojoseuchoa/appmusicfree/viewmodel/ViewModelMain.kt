package br.com.antoniojoseuchoa.appmusicfree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.antoniojoseuchoa.appmusicfree.data.RepositoryPlaylist
import br.com.antoniojoseuchoa.appmusicfree.domain.Music
import br.com.antoniojoseuchoa.appmusicfree.domain.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMain: ViewModel() {

    private var _playlist = MutableLiveData<States>()
    val playlist: LiveData<States> = _playlist

    fun getListPlaylist(){
            _playlist.value = States.loader

            RepositoryPlaylist.retrofit.getPlaylist().enqueue(object : Callback<Music>{
                override fun onResponse(call: Call<Music>, response: Response<Music>) {
                       if(response != null){
                            _playlist.value = States.OnSucess(response.body()!!.playlist)
                       }
                }

                override fun onFailure(call: Call<Music>, t: Throwable) {
                     _playlist.value = States.Erro(t.message.toString())
                }

            })
    }

    sealed class States {
        object loader : States()
        class Erro(var mensagem: String) : States()
        class OnSucess(var list: List<Playlist>): States()
   }
}

