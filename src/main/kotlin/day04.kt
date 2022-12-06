import day04.Section
import utils.readInput

fun main() {
    val day04 = Day04()

    val smallInput = day04.getSmallInput()
    val largeInput = day04.getLargeInput()

    val answerPartOneSmallInput = day04.partOne(smallInput)
    println("Answer to part one (small input): ${answerPartOneSmallInput}.")
    check(answerPartOneSmallInput == 2)
    println("Answer to part one (large input): ${day04.partOne(largeInput)}.")

    val answerPartTwoSmallInput = day04.partTwo(smallInput)
    println("Answer to part two (small input): ${answerPartTwoSmallInput}.")
    check(answerPartTwoSmallInput == 4)
    println("Answer to part two (small input): ${day04.partTwo(largeInput)}.")
}

class Day04 {
    fun partOne(input: List<String>): Int {
        var numberOfSectionsFullyIncludedIn = 0

        input.forEach { row ->
            val sections = this.getSectionsFromRow(row)

            if (
                sections[0].isFullyIncludedIn(sections[1]) ||
                sections[1].isFullyIncludedIn(sections[0])
            ) {
                numberOfSectionsFullyIncludedIn++
            }
        }

        return numberOfSectionsFullyIncludedIn
    }

    fun partTwo(input: List<String>): Int {
        var numberOfSectionsOverlaps = 0

        input.forEach { row ->
            val sections = this.getSectionsFromRow(row)

            if (
                sections[0].isOverlaps(sections[1]) ||
                sections[1].isOverlaps(sections[0])
            ) {
                numberOfSectionsOverlaps++
            }
        }

        return numberOfSectionsOverlaps
    }

    private fun getSectionsFromRow(row: String): Array<Section> {
        var sections = emptyArray<Section>()

        val rowParts = row.split(",")
        rowParts.forEach {
            val (min, max) = it.split("-").map { bound -> bound.toInt() }
            sections += Section(min, max)
        }

        return sections
    }

    fun getSmallInput(): List<String> {
        return readInput("src/inputs/day04_01-small-input.txt")
    }

    fun getLargeInput(): List<String> {
        return readInput("src/inputs/day04_02-large-input.txt")
    }
}