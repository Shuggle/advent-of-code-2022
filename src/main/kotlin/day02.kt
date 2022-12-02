import day02.Round
import day02.Shape
import utils.readInput

fun main() {
    val day02 = Day02()

    val smallInput = day02.getSmallInput()
    val largeInput = day02.getLargeInput()

    val answerPartOneSmallInput = day02.partOne(smallInput)
    println("Answer to part one (small input): ${answerPartOneSmallInput}.")
    check(answerPartOneSmallInput == 15)
    println("Answer to part one (large input): ${day02.partOne(largeInput)}.")
//
//    val answerPartTwoSmallInput = day02.partTwo(smallInput)
//    println("Answer to part two (small input): ${answerPartTwoSmallInput}.")
//    check(answerPartTwoSmallInput == 45000)
//    println("Answer to part two (small input): ${day02.partTwo(largeInput)}.")
}

class Day02 {
    fun partOne(input: List<String>): Int {
        val scores = emptyList<IntArray>().toMutableList()

        input.forEach { row ->
            val shapes = row.split(" ").map { Shape(it) }
            val score = Round(shapes[0], shapes[1]).getScores()
            scores.add(score)
        }

        return scores.sumOf { it[1] }
    }

    fun partTwo(input: List<String>): Int {
        return -1
    }

    fun getSmallInput(): List<String> {
        return readInput("src/inputs/day02_01-small-input.txt")
    }

    fun getLargeInput(): List<String> {
        return readInput("src/inputs/day02_02-large-input.txt")
    }
}