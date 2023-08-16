package com.example.islamiapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.R
import com.example.islamiapp.ui.home.HomeActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        openHomeActivity()
    }

    private fun openHomeActivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(Intent(this, HomeActivity::class.java))
            }, 2000)
    }
}