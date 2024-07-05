package com.example.tictactoeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class SplashScreen : AppCompatActivity() {

    private val splashScreenTime: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        CoroutineScope(Dispatchers.Main).launch {
            delay(splashScreenTime)
            startActivity(Intent(this@SplashScreen, GameBoard::class.java))
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        CoroutineScope(Dispatchers.Main).cancel()
    }
}
