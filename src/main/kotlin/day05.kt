import day05.Move
import day05.MoveParser
import day05.Stack
import day05.StackParser
import utils.readInput

fun main() {
    val day05 = Day05()

    val smallInput = day05.getSmallInput()
    val largeInput = day05.getLargeInput()

    val answerPartOneSmallInput = day05.partOne(smallInput)
    println("Answer to part one (small input): ${answerPartOneSmallInput}.")
    check(answerPartOneSmallInput == "CMZ")
    println("Answer to part one (large input): ${day05.partOne(largeInput)}.")

    val answerPartTwoSmallInput = day05.partTwo(smallInput)
    println("Answer to part two (small input): ${answerPartTwoSmallInput}.")
    check(answerPartTwoSmallInput == "MCD")
    println("Answer to part two (small input): ${day05.partTwo(largeInput)}.")
}

class Day05 {
    fun partOne(input: List<String>): String {
        val stacks = this.getStacks(input)
        val moves = this.getMoves(input)

        moves.forEach {
            this.move(it.number, stacks[it.sourceStackIndex], stacks[it.destinationStackIndex])
        }


        return stacks.map { it.getLast() }.joinToString("")
    }

    fun partTwo(input: List<String>): String {
        val stacks = this.getStacks(input)
        val moves = this.getMoves(input)

        moves.forEach {
            this.moveAndPreserveOrder(it.number, stacks[it.sourceStackIndex], stacks[it.destinationStackIndex])
        }


        return stacks.map { it.getLast() }.joinToString("")
    }

    private fun getStacks(input: List<String>): Array<Stack> {
        val stackParser = StackParser()

        for (row in input) {
            if (!row.contains("[")) {
                break
            }

            stackParser.parse(row)
        }

        return stackParser.stacks
    }

    private fun getMoves(input: List<String>): Array<Move> {
        var moves = emptyArray<Move>()
        val movesStartIndex = input.indexOf("") + 1
        val moveParser = MoveParser()

        for (i in movesStartIndex until input.size) {
            moves += moveParser.parse(input[i])
        }

        return moves
    }

    private fun move(number: Int, sourceStack: Stack, destinationStack: Stack) {
        repeat(number) {
            destinationStack.addCrate(sourceStack.removeCrate())
        }
    }

    private fun moveAndPreserveOrder(number: Int, sourceStack: Stack, destinationStack: Stack) {
        var cratesRemoved = emptyArray<Char>()
        repeat(number) {
            cratesRemoved += sourceStack.removeCrate()
        }

        cratesRemoved.reversed().forEach {
            destinationStack.addCrate(it)
        }
    }

    fun getSmallInput(): List<String> {
        return readInput("src/inputs/day05_01-small-input.txt")
    }

    fun getLargeInput(): List<String> {
        return readInput("src/inputs/day05_02-large-input.txt")
    }
}