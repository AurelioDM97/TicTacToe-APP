package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.tictactoeapp.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val player1 = ArrayList<Int>()
    private val player2 = ArrayList<Int>()
    private var playersTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick(view : View) {
        if(playersTurn) {
            val imageView = view as View
            val singleCell = when (imageView.id) {
                R.id.imageView1 -> 1
                R.id.imageView2 -> 2
                R.id.imageView3 -> 3
                R.id.imageView4 -> 4
                R.id.imageView5 -> 5
                R.id.imageView6 -> 6
                R.id.imageView7 -> 7
                R.id.imageView8 -> 8
                R.id.imageView9 -> 9
                else -> 0
            }
            playersTurn = false

        }
    }
}