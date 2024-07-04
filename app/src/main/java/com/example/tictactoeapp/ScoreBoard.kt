package com.example.tictactoeapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoeapp.databinding.ActivityBoardScoreBinding

class ScoreBoard: AppCompatActivity() {
    private lateinit var binding: ActivityBoardScoreBinding
    private lateinit var gameResult: GameResults

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameResult = GameResults(this)

        val scoreList = binding.scoreListView

        // Lista per visualizzare lo storico
        val viewingList = listOf(
            "Player 1 wins: ${gameResult.getPlayer1Wins()}",
            "Player 2 wins: ${gameResult.getPlayer2Wins()}"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, viewingList)
        scoreList.adapter = adapter
    }
}
