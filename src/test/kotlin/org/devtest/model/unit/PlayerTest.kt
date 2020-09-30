package org.devtest.model.unit


import org.devtest.model.Player
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach


class PlayerTest {



    private lateinit var player: Player

    @BeforeEach
    fun initPlayer() {
        player = Player()
    }

    @Test
    fun givenPlayerCreated_whenInit_thenTogglePosition1() {

        assertEquals(TestConstants.EXPECTED_POSITION_START, player.tokenPosition)
    }

    @Test
    fun givenPlayerCreated_whenMove3Spaces_thenTogglePosition4() {

        player.move(TestConstants.MOVE_3_SPACES)

        assertEquals(TestConstants.EXPECTED_POSITION_4, player.tokenPosition)
    }


    @Test
    fun givenPlayerCreated_whenMove3SpacesAndMove4Spaces_thenTogglePosition8() {

        player.move(TestConstants.MOVE_3_SPACES)
        player.move(TestConstants.MOVE_4_SPACES)

        assertEquals(TestConstants.EXPECTED_POSITION_8, player.tokenPosition)
    }
}