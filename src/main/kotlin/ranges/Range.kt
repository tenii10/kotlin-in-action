package ranges

fun main() {
    // A range is essentially just an interval between two values, usually numbers:
    // a start and an end. You write it using the .. operator
    // Ranges in Kotlin are closed or inclusive, meaning the second value is always a part of the range.
    for (i in 1..100) {
        println(fizzBuzz(i))
    }

     // If you can iterate over all the values in a range, such a range is called a progression.

    // Iterating over a range with a step,
    // counting backward from 100 and include only even numbers
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
}

// Using when to implement the Fizz-Buzz game
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}