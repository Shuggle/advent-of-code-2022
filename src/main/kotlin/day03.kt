import utils.readInput

fun main() {
    val day03 = Day03()

    val smallInput = day03.getSmallInput()
    val largeInput = day03.getLargeInput()

    val answerPartOneSmallInput = day03.partOne(smallInput)
    println("Answer to part one (small input): ${answerPartOneSmallInput}.")
    check(answerPartOneSmallInput == 157)
    println("Answer to part one (large input): ${day03.partOne(largeInput)}.")

    val answerPartTwoSmallInput = day03.partTwo(smallInput)
    println("Answer to part two (small input): ${answerPartTwoSmallInput}.")
    check(answerPartTwoSmallInput == 70)
    println("Answer to part two (small input): ${day03.partTwo(largeInput)}.")
}

class Day03 {
    fun partOne(input: List<String>): Int {
        val misplacedItems = mutableListOf<Char>()

        input.forEach {
            val compartmentContent = it.chunked(it.length / 2)
            misplacedItems.add(
                this.getMisplacedItem(
                    compartmentContent[0].toCharArray(),
                    compartmentContent[1].toCharArray()
                ).first()
            )
        }

        return misplacedItems.sumOf { this.getItemValue(it) }
    }

    private fun getMisplacedItem(firstItem: CharArray, secondItem: CharArray): CharArray {
        return firstItem.toList().intersect(secondItem.toList().toSet()).toCharArray()
    }

    fun partTwo(input: List<String>): Int {
        val badges = mutableListOf<Char>()

        input.chunked(3).forEach { items ->
            val badge = items.map { it.toCharArray() }.reduce { acc, item -> this.getMisplacedItem(item, acc) }.first()
            badges.add(badge)
        }

        return badges.sumOf { this.getItemValue(it) }
    }

    private fun getItemValue(item: Char): Int {
        return if (item.isUpperCase()) item.code - 38 else item.code - 96
    }

    fun getSmallInput(): List<String> {
        return readInput("src/inputs/day03_01-small-input.txt")
    }

    fun getLargeInput(): List<String> {
        return readInput("src/inputs/day03_02-large-input.txt")
    }
}