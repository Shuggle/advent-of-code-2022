package day02

class Round(private val playerOneShape: Shape, private var playerTwoShape: Shape) {
    fun getScores(): IntArray {
        if (playerOneShape > playerTwoShape) {
            return intArrayOf(
                this.getScore(playerOneShape, RoundResult.WIN),
                this.getScore(playerTwoShape, RoundResult.LOSE),
            )
        }

        if (playerOneShape < playerTwoShape) {
            return intArrayOf(
                this.getScore(playerOneShape, RoundResult.LOSE),
                this.getScore(playerTwoShape, RoundResult.WIN),
            )
        }

        return intArrayOf(
            this.getScore(playerOneShape, RoundResult.DRAW),
            this.getScore(playerTwoShape, RoundResult.DRAW),
        )
    }

    private fun getScore(shape: Shape, roundResult: RoundResult): Int {
        return shape.getPoints() + this.getOutcome(roundResult)
    }

    private fun getOutcome(roundResult: RoundResult): Int {
        return when (roundResult) {
            RoundResult.WIN -> 6
            RoundResult.DRAW -> 3
            RoundResult.LOSE -> 0
        }
    }

    fun predictPlayerTwoShape(): Shape {
        return when (this.playerTwoShape.getShape()) {
            "X" -> this.playerOneShape.winVersus()
            "Y" -> this.playerOneShape.drawVersus()
            "Z" -> this.playerOneShape.loseVersus()
            else -> this.playerOneShape
        }
    }

    fun setPlayerTwoShape(playerTwoShape: Shape) {
        this.playerTwoShape = playerTwoShape
    }
}

