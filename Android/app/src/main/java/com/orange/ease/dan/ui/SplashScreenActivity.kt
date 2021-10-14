package com.orange.ease.dan.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.orange.ease.dan.databinding.SplashBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: SplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initTimer()
    }

    fun startMenuActivity() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun initTimer() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startMenuActivity()
            },
            3000
        )
    }

}


