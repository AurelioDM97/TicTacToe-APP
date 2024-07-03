package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.tictactoeapp.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val player1 = ArrayList<Int>()
    private val player2 = ArrayList<Int>()
    private var currentPlayer = 1
    private var playersTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView1.setOnClickListener { onClick(it) }
        binding.imageView2.setOnClickListener { onClick(it) }
        binding.imageView3.setOnClickListener { onClick(it) }
        binding.imageView4.setOnClickListener { onClick(it) }
        binding.imageView5.setOnClickListener { onClick(it) }
        binding.imageView6.setOnClickListener { onClick(it) }
        binding.imageView7.setOnClickListener { onClick(it) }
        binding.imageView8.setOnClickListener { onClick(it) }
        binding.imageView9.setOnClickListener { onClick(it) }
    }

    fun onClick(view : View) {
        if(playersTurn) {
            val imageView = view as ImageView
            val gridId = when (imageView.id) {
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

            setGame(imageView, gridId)
        }
    }
    private fun setGame(imageView: ImageView, gridId: Int) {
        if (currentPlayer == 1) {
            imageView.setImageResource(R.drawable.swords)
            player1.add(gridId)
            imageView.isEnabled = false

        } else {
            imageView.setImageResource(R.drawable.shield)
            player2.add(gridId)
            imageView.isEnabled = false

        }

    }
}