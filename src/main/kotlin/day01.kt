import utils.readInput

fun main() {
    val day01 = Day01()

    val smallInput = day01.getSmallInput()
    val largeInput = day01.getLargeInput()

    val answerPartOneSmallInput = day01.partOne(smallInput)
    println("Answer to part one (small input): ${answerPartOneSmallInput}.")
    check(answerPartOneSmallInput == 24000)
    println("Answer to part one (large input): ${day01.partOne(largeInput)}.")

    val answerPartTwoSmallInput = day01.partTwo(smallInput)
    println("Answer to part two (small input): ${answerPartTwoSmallInput}.")
    check(answerPartTwoSmallInput == 45000)
    println("Answer to part two (large input): ${day01.partTwo(largeInput)}.")
}

class Day01 {
    fun partOne(input: List<String>): Int {
        return this.getTotalCaloriesByElves(input).max()
    }

    fun partTwo(input: List<String>): Int {
        return this.getTotalCaloriesByElves(input).sortedDescending().take(3).sum()
    }

    private fun getTotalCaloriesByElves(input: List<String>): List<Int> {
        return input
            .joinToString(",")
            .split(",,")
            .map { it.split(",").toInt() }
            .map { it.sum() }
    }

    private fun List<String>.toInt(): List<Int> {
        return this.map { it.toInt() }
    }

    fun getSmallInput(): List<String> {
        return readInput("src/inputs/day01_01-small-input.txt")
    }

    fun getLargeInput(): List<String> {
        return readInput("src/inputs/day01_02-large-input.txt")
    }
}