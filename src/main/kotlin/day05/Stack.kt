package day05

class Stack() {
    private val crates: ArrayDeque<Char> = ArrayDeque()

    fun addCrate(crate: Char) {
        this.crates.addLast(crate)
    }

    fun addCrateFromTop(crate: Char) {
        this.crates.addFirst(crate)
    }

    fun removeCrate(): Char {
        return this.crates.removeLast()
    }

    fun getLast(): Char {
        return this.crates.last()
    }
}