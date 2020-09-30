package org.devtest.model.unit

import org.devtest.model.Player
import org.devtest.model.impl.EndGameRule
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EndGameRuleTest {

    lateinit var player: Player

    @BeforeEach
    fun setUpPlayer() {
        player = Player()
    }

    @Test
    fun givenEndgamePosition_whenPerformCheck_thenWin() {

        val endgameRule = EndGameRule()
        player.tokenPosition = TestConstants.ENDGAME_POSITION
        endgameRule.applyRule(player)



        assertTrue(player.isWin)

    }

    @Test
    fun givenNonEndgamePosition_whenPerformCheck_thenNotWin() {
        val endgameRule = EndGameRule()
        player.tokenPosition = TestConstants.NON_ENDGAME_POSITION
        endgameRule.applyRule(player)

        assertFalse(player.isWin)
    }
}