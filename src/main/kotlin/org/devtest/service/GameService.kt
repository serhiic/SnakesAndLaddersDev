package org.devtest.service

import org.devtest.model.*

class GameService(

    private val dice: Rollable,
    private val rules: Collection<GameRule>
) {

    fun performMove(player: Player): MoveResult {

        player.move(dice.roll())

        rules.forEach {
            it.applyRule(player)
        }
        if (player.isWin) return MoveResult.WIN

        return MoveResult.NEXT_MOVE
    }

}