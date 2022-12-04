import utils.readInput

fun main() {
    val day03 = Day03()

    val smallInput = day03.getSmallInput()
    val largeInput = day03.getLargeInput()

    val answerPartOneSmallInput = day03.partOne(smallInput)
    println("Answer to part one (small input): ${answerPartOneSmallInput}.")
    check(answerPartOneSmallInput == 157)
    println("Answer to part one (large input): ${day03.partOne(largeInput)}.")

//    val answerPartTwoSmallInput = day03.partTwo(smallInput)
//    println("Answer to part two (small input): ${answerPartTwoSmallInput}.")
//    check(answerPartTwoSmallInput == 12)
//    println("Answer to part two (small input): ${day03.partTwo(largeInput)}.")
}

class Day03 {
    fun partOne(input: List<String>): Int {
        val misplacedItems = mutableListOf<Char>()

        input.forEach {
            misplacedItems.add(this.getMisplacedItem(it))
        }

        return misplacedItems.sumOf { if (it.isUpperCase()) it.code - 38 else it.code - 96 }
    }

    fun partTwo(input: List<String>): Int {
        return -1
    }

    private fun getMisplacedItem(items: String): Char {
        val compartmentContent = items.chunked(items.length / 2)
        return compartmentContent[0].toList().intersect(compartmentContent[1].toList().toSet()).first()
    }

    fun getSmallInput(): List<String> {
        return readInput("src/inputs/day03_01-small-input.txt")
    }

    fun getLargeInput(): List<String> {
        return readInput("src/inputs/day03_02-large-input.txt")
    }
}