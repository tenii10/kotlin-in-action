package exceptions

import java.io.BufferedReader
import java.io.StringReader

fun main() {
    checkPercentage(1)
    // checkPercentage(150)
    println(readNumber(BufferedReader(StringReader("136"))))
}

fun checkPercentage(percentage: Int) {
    if (percentage !in 0..100) {
        throw IllegalArgumentException(
            "A percentage value must be between 0 and 100: $percentage"
        )
    }
}

// The biggest difference from Java is that the "throws" clause isn’t present in the code
// Just like many other modern JVM languages, Kotlin doesn’t differentiate between checked and unchecked exceptions.
fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}