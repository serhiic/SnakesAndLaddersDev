package org.devtest.model.impl

import org.devtest.model.GameConstants
import org.devtest.model.Rollable
import kotlin.random.Random

class DefaultDice : Rollable {
    override fun roll(): Int {
        return Random.nextInt(GameConstants.DICE_MIN, GameConstants.DICE_MAX)
    }
}