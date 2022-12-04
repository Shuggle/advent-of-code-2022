package day02

class Shape(private val shape: String) {
    private val shapeConfig = ShapeConfig()

    fun getPoints(): Int {
        return this.shapeConfig.points[this.shape] ?: 0
    }

    fun winVersus(): Shape {
        return this.getShapeByCondition { this > it }
    }

    fun drawVersus(): Shape {
        return this.getShapeByCondition { this == it }
    }

    fun loseVersus(): Shape {
        return this.getShapeByCondition { this < it }
    }

    private fun getShapeByCondition(condition: (shape: Shape) -> Boolean): Shape {
        var answer: Shape? = null

        this.shapeConfig.playerTwoShapes.forEach {
            val shape = Shape(it)
            if (condition(shape)) {
                answer = shape
            }
        }

        return answer!!
    }

    fun getShape(): String {
        return this.shape
    }

    operator fun compareTo(otherShape: Shape): Int {
        if (this == otherShape) {
            return 0
        }

        if (this.shape == "A" && otherShape.shape == "Z") {
            return 1
        }

        if (this.shape == "B" && otherShape.shape == "X") {
            return 1
        }

        if (this.shape == "C" && otherShape.shape == "Y") {
            return 1
        }

        return -1
    }

    override fun equals(other: Any?): Boolean {
        if (
            other is Shape &&
            (
                    (this.shape == "A" && other.shape == "X") ||
                            (this.shape == "B" && other.shape == "Y") ||
                            (this.shape == "C" && other.shape == "Z")
                    )
        ) {
            return true
        }

        return false
    }

    override fun hashCode(): Int {
        var result = shape.hashCode()
        result = 31 * result + shapeConfig.hashCode()
        return result
    }
}

