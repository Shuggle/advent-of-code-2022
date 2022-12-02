package day02

class Shape(private val shape: String) {
    fun getPoints(): Int {
        return this.points[this.shape] ?: 0
    }

    operator fun compareTo(otherShape: Shape): Int {
        if (
            (arrayOf("A", "X").contains(this.shape) && arrayOf("A", "X").contains(otherShape.shape)) ||
            (arrayOf("B", "Y").contains(this.shape) && arrayOf("B", "Y").contains(otherShape.shape)) ||
            (arrayOf("C", "Z").contains(this.shape) && arrayOf("C", "Z").contains(otherShape.shape))
        ) {
            return 0
        }

        if (arrayOf("A", "X").contains(this.shape)) {
            return if (arrayOf("C", "Z").contains(otherShape.shape)) 1 else -1
        }

        if (arrayOf("B", "Y").contains(this.shape)) {
            return if (arrayOf("A", "X").contains(otherShape.shape)) 1 else -1
        }

        if (arrayOf("C", "Z").contains(this.shape)) {
            return if (arrayOf("B", "Y").contains(otherShape.shape)) 1 else -1
        }

        return 0
    }

    private val points = mapOf(
        "A" to 1,
        "B" to 2,
        "C" to 3,
        "X" to 1,
        "Y" to 2,
        "Z" to 3,
    )
}

