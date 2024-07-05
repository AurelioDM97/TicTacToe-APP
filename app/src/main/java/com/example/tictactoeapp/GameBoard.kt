package com.example.tictactoeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.tictactoeapp.databinding.ActivityBoardGameBinding
import com.example.tictactoeapp.model.GameConditionRepository
import com.example.tictactoeapp.model.GameState

class GameBoard : AppCompatActivity() {
    private lateinit var binding: ActivityBoardGameBinding
    private lateinit var gameResult: GameResults
    private lateinit var gameCondition: GameConditionRepository
    private lateinit var gameState: GameState
    //private var winnerDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toolbar per il nome dell'app
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Medieval OX"



        gameResult = GameResults(this)
        gameCondition = GameConditionRepository()
        gameState = GameState()

        binding.imageView1.setOnClickListener { onClick(it) }
        binding.imageView2.setOnClickListener { onClick(it) }
        binding.imageView3.setOnClickListener { onClick(it) }
        binding.imageView4.setOnClickListener { onClick(it) }
        binding.imageView5.setOnClickListener { onClick(it) }
        binding.imageView6.setOnClickListener { onClick(it) }
        binding.imageView7.setOnClickListener { onClick(it) }
        binding.imageView8.setOnClickListener { onClick(it) }
        binding.imageView9.setOnClickListener { onClick(it) }

        val button = binding.scoreBoardBtn

        button.setOnClickListener() {
            val intent = Intent(this, ScoreBoard::class.java)
            startActivity(intent)
        }
    }

    private fun onClick(view: View) {
        if (gameState.playersTurn) {
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
            gameState.playersTurn = false
            // metodo per dare scaglionare i turni dei due giocatori
            Handler(Looper.getMainLooper()).postDelayed({ gameState.playersTurn = true }, 600)
            setGame(imageView, gridId)
        }
    }

    private fun setGame(imageView: ImageView, gridId: Int) {
        if (gameState.currentPlayer == 1) {
            imageView.setImageResource(R.drawable.swords)
            gameState.player1.add(gridId)
            imageView.isEnabled = false
            gameState.currentPlayer = 2
        } else {
            imageView.setImageResource(R.drawable.shield)
            gameState.player2.add(gridId)
            imageView.isEnabled = false
            gameState.currentPlayer = 1
        }

        val winner = gameCondition.checkWinner(gameState.player1, gameState.player2) //condizioni di vittoria
        if (winner == 1 || winner == 2) {
            winnerPopup(winner)
        } else if (gameState.player1.size == 5 && gameState.player2.size == 4) {
            winnerPopup(0)
        }

        Handler(Looper.getMainLooper()).postDelayed({ gameState.playersTurn = true }, 600)

    }
    private fun winnerPopup(winner: Int) {
        val message = when (winner) {
            1 -> "Player 1 wins!"
            2 -> "Player 2 wins!"
            else -> "Draw!"
        }
        if (winner == 1) {
            gameResult.gameResult(true)
        } else if (winner == 2) {
            gameResult.gameResult(false)
        }

        AlertDialog.Builder(this@GameBoard)
            .setTitle("End Game")
            .setMessage(message)
            .setPositiveButton("Restart") { _, _ -> resetGame() }
            .setCancelable(false)
            .show()

    }
    //gestione errore popup
    /*override fun onDestroy() {
        super.onDestroy()
        winnerDialog?.dismiss()  // Assicura di chiudere il dialogo se l'activity viene distrutta
    }*/

    /*private fun endGame(player1win: Boolean) {
    }*/

    private fun resetGame() { //bottone dell'alert per resettare il gioco e ricominciare da capo
        gameState.player1.clear()
        gameState.player2.clear()
        gameState.currentPlayer = 1
        gameState.playersTurn = true

        binding.imageView1.setImageResource(0)
        binding.imageView2.setImageResource(0)
        binding.imageView3.setImageResource(0)
        binding.imageView4.setImageResource(0)
        binding.imageView5.setImageResource(0)
        binding.imageView6.setImageResource(0)
        binding.imageView7.setImageResource(0)
        binding.imageView8.setImageResource(0)
        binding.imageView9.setImageResource(0)

        binding.imageView1.isEnabled = true
        binding.imageView2.isEnabled = true
        binding.imageView3.isEnabled = true
        binding.imageView4.isEnabled = true
        binding.imageView5.isEnabled = true
        binding.imageView6.isEnabled = true
        binding.imageView7.isEnabled = true
        binding.imageView8.isEnabled = true
        binding.imageView9.isEnabled = true

    }
    private fun setTurn() {


    }

}