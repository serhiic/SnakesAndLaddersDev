package org.devtest.model.integration

import org.devtest.model.Player
import org.devtest.model.Rollable
import org.devtest.model.impl.DefaultDice
import org.devtest.model.impl.EndGameRule
import org.devtest.model.impl.PositionBoundariesRule
import org.devtest.model.unit.TestConstants
import org.devtest.service.GameService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class GameServiceIntegrationTest {

    lateinit var gameService: GameService
    lateinit var player: Player
    lateinit var dice: Rollable

    @BeforeEach
    fun setUpService() {
        player = Player()
        dice = Mockito.mock(DefaultDice::class.java)
        gameService = GameService(dice, listOf(EndGameRule(), PositionBoundariesRule()))
    }

    @Test
    fun givenTokenOnSquare1_whenMove3Space_thenTogglePosition4() {

        Mockito.`when`(dice.roll()).thenReturn(TestConstants.DICE_ROLL_3)

        gameService.performMove(player)

        assertEquals(TestConstants.EXPECTED_POSITION_4, player.tokenPosition)

    }

    @Test
    fun givenTokenOnSquare1_whenDiceRoll3AndThenDiceRoll4_thenTogglePosition8() {
        Mockito.`when`(dice.roll()).thenReturn(TestConstants.DICE_ROLL_3)

        gameService.performMove(player)
        Mockito.`when`(dice.roll()).thenReturn(TestConstants.DICE_ROLL_4)
        gameService.performMove(player)

        assertEquals(TestConstants.EXPECTED_POSITION_8, player.tokenPosition)

    }

    @Test
    fun givenTokenOnSquare99_whenDiceRoll1_thenPlayerWin() {
        player.tokenPosition = TestConstants.NON_ENDGAME_POSITION
        Mockito.`when`(dice.roll()).thenReturn(TestConstants.DICE_ROLL_MIN)

        gameService.performMove(player)

        assertTrue(player.isWin)

    }

    @Test
    fun givenTokenOnSquare99_whenDiceRoll3_thenPlayerNotWin() {
        player.tokenPosition = TestConstants.NON_ENDGAME_POSITION
        Mockito.`when`(dice.roll()).thenReturn(TestConstants.DICE_ROLL_3)

        gameService.performMove(player)

        assertFalse(player.isWin)
    }
    @Test
    fun givenTokenOnSquare99_whenDiceRoll3_thenTokenPositionUnchanged() {
        player.tokenPosition = TestConstants.NON_ENDGAME_POSITION
        Mockito.`when`(dice.roll()).thenReturn(TestConstants.DICE_ROLL_3)

        gameService.performMove(player)

        assertEquals(TestConstants.NON_ENDGAME_POSITION, player.tokenPosition)
    }

}