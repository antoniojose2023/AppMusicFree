package br.com.antoniojoseuchoa.appmusicfree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.antoniojoseuchoa.appmusicfree.databinding.ActivityListMusicBinding

class ListMusicActivity : AppCompatActivity() {
    private val binding by lazy { ActivityListMusicBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }
}