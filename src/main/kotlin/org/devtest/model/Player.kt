package org.devtest.model

data class Player(var tokenPosition: Int = GameConstants.START_TOKEN_POSITION, var isWin: Boolean = false) {

    private var previousMoveSteps = 0

    fun move(steps: Int) {
        previousMoveSteps = steps
        tokenPosition += steps
    }

    fun rollbackMove() {
        tokenPosition -= previousMoveSteps
    }


}