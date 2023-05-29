package collections

fun main() {
    // creating collections
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    // javaClass is Kotlin equivalent of Java’s getClass().
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}