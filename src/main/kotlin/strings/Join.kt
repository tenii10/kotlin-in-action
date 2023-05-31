@file:JvmName("StringFunctions") // specify the class name

package strings

// overload for Java calls
@JvmOverloads
// top-level function
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ", // default value
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// top-level properties
var opCount = 0

fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}

fun main() {
    performOperation()
    reportOperationCount()

    println("asdf".lastChar())

    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}

// a public static final field in Kotlin
const val UNIX_LINE_SEPARATOR = "\n"

// extension function:
// String - Receiver type; this - Receiver object
fun String.lastChar(): Char = this.get(this.length - 1)

// Receiver object members can be accessed without “this”
// fun String.lastChar(): Char = get(length - 1)

// Declaring an extension property
val String.lastChar: Char
    get() = get(length - 1)

//Declaring a mutable extension property
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }