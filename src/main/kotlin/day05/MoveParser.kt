package day05

class MoveParser() {
    fun parse(input: String): Move {
        val pattern = "move (?<number>\\d*) from (?<sourceStackIndex>\\d*) to (?<destinationStackIndex>\\d*)".toRegex()
        val matches = pattern.matchEntire(input)?.groups

        val number = matches?.get("number")?.value?.toInt() ?: -1
        val sourceStackIndex = (matches?.get("sourceStackIndex")?.value?.toInt()?.minus(1)) ?: -1
        val destinationStackIndex = (matches?.get("destinationStackIndex")?.value?.toInt()?.minus(1)) ?: -1

        return Move(number, sourceStackIndex, destinationStackIndex)
    }
}