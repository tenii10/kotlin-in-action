package enums

import enums.Color.*

// Declaring a simple enum class
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

// Declaring an enum class with properties
enum class ColorRGB(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun main() {
    println(ColorRGB.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
    println(getWarmth(Color.ORANGE))
    println(mix(Color.BLUE, Color.VIOLET))
}

//  Using when for choosing the right enum value
fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

// Combining options in one when branch
fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

// Using different objects in when branches
fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("Dirty color")
}

// when without an argument
fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == RED && c2 == YELLOW) ||
            (c1 == YELLOW && c2 == RED) -> ORANGE

    (c1 == YELLOW && c2 == BLUE) ||
            (c1 == BLUE && c2 == YELLOW) -> GREEN

    (c1 == BLUE && c2 == VIOLET) ||
            (c1 == VIOLET && c2 == BLUE) -> INDIGO

    else -> throw Exception("Dirty color")
}