package br.com.antoniojoseuchoa.appmusicfree.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.appmusicfree.databinding.ItemMusicBinding
import br.com.antoniojoseuchoa.appmusicfree.domain.Musica
import br.com.antoniojoseuchoa.appmusicfree.domain.Playlist

class AdapterMusic(val context: Context, val list: List<Musica>, val onClickMusicListener: OnClickMusicListener): RecyclerView.Adapter<AdapterMusic.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemMusicBinding.inflate(layoutInflater, parent, false )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind( item )
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(val binding: ItemMusicBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item: Musica){
                   binding.tvNameMusic.text = item.nome

                   binding.root.setOnClickListener {
                       onClickMusicListener.onClickMusic( item )
                   }
            }
    }

    interface OnClickMusicListener{
        fun onClickMusic(music: Musica)
    }
}