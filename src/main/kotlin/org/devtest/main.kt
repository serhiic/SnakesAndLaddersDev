package org.devtest

import org.devtest.model.MoveResult
import org.devtest.model.Player
import org.devtest.model.impl.DefaultDice
import org.devtest.model.impl.EndGameRule
import org.devtest.model.impl.PositionBoundariesRule
import org.devtest.service.GameService

fun main() {
    val player = Player()
    val gameService = GameService(DefaultDice(), listOf(EndGameRule(), PositionBoundariesRule()))

    for (i in 1..100) {
        val moveResult = gameService.performMove(player)
        println("Token position: ${player.tokenPosition}")
        println("Is win $moveResult")
        if (moveResult == MoveResult.WIN) {
            break
        }
    }
}