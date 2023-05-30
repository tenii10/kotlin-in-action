@file:JvmName("StringFunctions") // specify the class name

package strings

// overload for Java calls
@JvmOverloads
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