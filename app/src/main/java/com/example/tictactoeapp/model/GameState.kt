package com.example.tictactoeapp.model

//inserire le winning condition e le variabili in data class
data class GameState(
    val player1: ArrayList<Int> = ArrayList(),
    val player2: ArrayList<Int> = ArrayList(),
    var currentPlayer: Int = 1,
    var playersTurn: Boolean = true,
)

class GameConditionRepository {
    private val allWinningCondition = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
        intArrayOf(1, 5, 9),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(3, 5, 7),
        intArrayOf(3, 6, 9),
    )

    fun checkWinner(player1: ArrayList<Int>,player2: ArrayList<Int> ) :Int {
        for (combination in allWinningCondition) {
            if (player1.containsAll(combination.toList())) {
                return 1
            } else if (player2.containsAll(combination.toList())) {
                return 2
            }
        }
              return 0
    }
}


