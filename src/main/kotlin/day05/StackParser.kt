package day05

class StackParser() {
    var stacks = emptyArray<Stack>()

    fun parse(input: String) {
        val crates = this.getCrates(input)

        if (this.stacks.isEmpty()) {
            this.stacks = Array(crates.size) { Stack() }
        }

        this.addCratesToStacks(crates)
    }

    private fun getCrates(input: String): CharArray {
        return input
            .replace("    ", " [?] ")
            .replace("[", "")
            .replace("]", "")
            .replace(" ", "")
            .toCharArray()
    }

    private fun addCratesToStacks(crates: CharArray) {
        for (i in crates.indices) {
            if (crates[i] != '?') {
                this.stacks[i].addCrateFromTop(crates[i])
            }
        }
    }
}