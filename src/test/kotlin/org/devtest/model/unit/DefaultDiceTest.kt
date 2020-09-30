package org.devtest.model.unit

import org.devtest.model.impl.DefaultDice
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DefaultDiceTest {

    @Test
    fun givenDiceCreated_whenRoll_shouldReturnValueFrom1to6() {
        val dice = DefaultDice()

        var isFailed = false

        for (i in 1..1000) {
            val rollResult = dice.roll()

            if (rollResult < TestConstants.DICE_ROLL_MIN || rollResult > TestConstants.DICE_ROLL_MAX) {
                isFailed = true
            }
        }
        assertFalse(isFailed)

    }
}