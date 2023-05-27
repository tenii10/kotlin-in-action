package exceptions

fun main() {
    checkPercentage(1)
    checkPercentage(150)
}

fun checkPercentage(percentage: Int) {
    if (percentage !in 0..100) {
        throw IllegalArgumentException(
            "A percentage value must be between 0 and 100: $percentage")
    }
}