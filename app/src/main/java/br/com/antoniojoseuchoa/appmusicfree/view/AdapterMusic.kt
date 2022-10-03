package br.com.antoniojoseuchoa.appmusicfree.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.appmusicfree.databinding.ItemPlaylistBinding
import br.com.antoniojoseuchoa.appmusicfree.domain.Playlist
import com.bumptech.glide.Glide

class AdapterMusic(val context: Context, val list: List<Playlist>, var onClickPlaylistListener: OnClickPlaylistListener): RecyclerView.Adapter<AdapterMusic.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemPlaylistBinding.inflate(layoutInflater, parent, false )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.bind( item, onClickPlaylistListener )
    }

    override fun getItemCount() = list.size

    class ViewHolder(val binding: ItemPlaylistBinding): RecyclerView.ViewHolder(binding.root){
           fun bind(item: Playlist, onClickPlaylistListener: OnClickPlaylistListener){
                //binding.tvNomeCategoria.text = item.categoria
                Glide.with(binding.root.context).load(item.url).into(binding.ivCategoria)

                binding.root.setOnClickListener {
                    onClickPlaylistListener.onClickPlaylist( item )
                }
           }

    }

    interface OnClickPlaylistListener{
        fun onClickPlaylist(playlist: Playlist)
    }

}