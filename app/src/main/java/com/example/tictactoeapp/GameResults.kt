package com.example.tictactoeapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class GameResults(context: Context) {
    private val scorePreferences: SharedPreferences =
        context.getSharedPreferences("score_board_history", Context.MODE_PRIVATE)

    fun getPlayer1Wins(): Int {
        return scorePreferences.getInt("player1wins", 0)
    }

    fun getPlayer2Wins(): Int {
        return scorePreferences.getInt("player2wins", 0)
    }
    fun gameResult(player1win: Boolean) {
        val editor = scorePreferences.edit()

        if (player1win) {
            val player1wins = scorePreferences.getInt("player1wins", 0) + 1
            editor.putInt("player1wins", player1wins).apply()
        } else {
            val player2wins = scorePreferences.getInt("player2wins", 0) + 1
            editor.putInt("player2wins", player2wins).apply()
        }

    }
}