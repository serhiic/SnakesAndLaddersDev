package org.devtest.model.impl

import org.devtest.model.GameConstants
import org.devtest.model.GameRule
import org.devtest.model.Player

class PositionBoundariesRule : GameRule {

    override fun applyRule(player: Player) {
        if (player.tokenPosition > GameConstants.MAX_BOARD_POSITION) {
            player.rollbackMove()
        }
    }
}