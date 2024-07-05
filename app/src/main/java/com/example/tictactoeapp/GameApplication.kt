package com.example.tictactoeapp

import android.app.Application
import android.content.Context

class GameApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        resetGameScore()
    }
//non riuscendo a resettare lo score alla chiusura (destroy) dell'app ho impostato un' Application che lo faccia all'avvio
    private fun resetGameScore() {
        val scorePreferences = getSharedPreferences("score_board_history", Context.MODE_PRIVATE)
        val editor = scorePreferences.edit()
        editor.putInt("player1wins", 0).apply()
        editor.putInt("player2wins", 0).apply()
    }
}
