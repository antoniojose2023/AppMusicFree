package br.com.antoniojoseuchoa.appmusicfree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.antoniojoseuchoa.appmusicfree.databinding.ActivitySplashBinding
import br.com.antoniojoseuchoa.appmusicfree.view.MainActivity

class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
               startActivity(Intent(this, MainActivity::class.java))
               overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 2000)

    }
}