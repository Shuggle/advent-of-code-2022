package day02

class Round(private val playerOneShape: Shape, private val playerTwoShape: Shape) {
    fun getScores(): IntArray {
        if (playerOneShape > playerTwoShape) {
            return intArrayOf(
                this.getScore(playerOneShape, RoundResult.WIN),
                this.getScore(playerTwoShape, RoundResult.LOST),
            )
        }

        if (playerOneShape < playerTwoShape) {
            return intArrayOf(
                this.getScore(playerOneShape, RoundResult.LOST),
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
            RoundResult.LOST -> 0
        }
    }
}

