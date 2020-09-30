package org.devtest.model.unit

import org.devtest.model.GameRule
import org.devtest.model.MoveResult
import org.devtest.model.Player
import org.devtest.model.Rollable
import org.devtest.service.GameService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class GameServiceTest {

    lateinit var player: Player
    private val testDice = object : Rollable {
        override fun roll() = TestConstants.DICE_ROLL_3
    }
    private val testEmptyRules = listOf<GameRule>()

    @BeforeEach
    fun setUpPlayer() {
        player = Player()
    }

    @Test
    fun givenDiceRoll3_whenPerformMove_positionMovedTo4() {
        val gameService = GameService(
            testDice,
            testEmptyRules
        )

        gameService.performMove(player)

        assertEquals(TestConstants.EXPECTED_POSITION_4, player.tokenPosition)

    }

    @Test
    fun givenWinPlayer_whenPerformMove_returnWinFlag() {
        val gameService = GameService(testDice, testEmptyRules)
        player.isWin = true

        val performMoveResult = gameService.performMove(player)

        assertEquals(MoveResult.WIN, performMoveResult)
    }

    @Test
    fun givenNotWinPlayer_whenPerformMove_returnNextMoveFlag() {
        val gameService = GameService(testDice, testEmptyRules)

        val performMoveResult = gameService.performMove(player)

        assertEquals(MoveResult.NEXT_MOVE, performMoveResult)
    }


}