package org.devtest.model.unit

import org.devtest.model.Player
import org.devtest.model.impl.PositionBoundariesRule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class PositionBoundariesRuleTest {

    private lateinit var player: Player
    private lateinit var boundariesRule: PositionBoundariesRule

    @BeforeEach
    fun setUpPlayer() {
        player = Player()
        boundariesRule = PositionBoundariesRule()

    }

    @Test
    fun givenPlayerPosition_whenMoveOutOfBoardBounds_thenPositionRollback() {

        player.tokenPosition = TestConstants.NON_ENDGAME_POSITION
        player.move(TestConstants.MOVE_4_SPACES)

        boundariesRule.applyRule(player)

        assertEquals(TestConstants.NON_ENDGAME_POSITION, player.tokenPosition)

    }

    @Test
    fun givenPlayerPosition_whenMoveNotOutOfBoardBounds_thenPositionNotRollback() {

        player.tokenPosition = TestConstants.EXPECTED_POSITION_START
        player.move(TestConstants.MOVE_3_SPACES)

        boundariesRule.applyRule(player)

        assertEquals(TestConstants.EXPECTED_POSITION_4, player.tokenPosition)
    }
}