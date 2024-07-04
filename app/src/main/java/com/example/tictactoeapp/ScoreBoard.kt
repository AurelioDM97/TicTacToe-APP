package com.example.tictactoeapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoeapp.databinding.ActivityBoardScoreBinding

class ScoreBoard: AppCompatActivity() {
    private lateinit var binding: ActivityBoardScoreBinding
    private lateinit var scorePreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scoreList = binding.scoreListView
        //gestione delle sharedpreferences
        scorePreferences = getSharedPreferences("score_board_history", MODE_PRIVATE)
        val player1wins = scorePreferences.getInt("player1wins", 0)
        val player2wins = scorePreferences.getInt("player2wins", 0)

        //lista per visualizzare lo storico da sistemare
        val viewingList = listOf(
            "Player 1 wins: $player1wins",
            "Player 2 wins: $player2wins"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, viewingList)
        scoreList.adapter = adapter

    }
    private fun gameResult(context: Context, player1win : Boolean) {
        val scoreSharedPreferences = context.getSharedPreferences("score_board_history", MODE_PRIVATE)
        val editor = scorePreferences.edit()

        if (player1win) {
            val player1wins = scoreSharedPreferences.getInt("player1wins", 0) +1
            editor.putInt("player1wins", player1wins).apply()
        }
        else {
            val player2wins = scoreSharedPreferences.getInt("player2wins", 0) +1
            editor.putInt("player2wins", player2wins).apply()
        }


    }
}