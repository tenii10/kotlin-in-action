package expressions

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// The "is" check is similar to "instanceof" in Java
/* In Kotlin, if you check the variable for a certain type, you don’t need to cast it afterward;
you can use it as having the type you checked for. In effect, the compiler performs the
cast for you, and we call it a smart cast. */
fun eval(e: Expr): Int {
    if (e is Num) {
        // An explicit cast to the specific type is expressed via the "as" keyword.
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun main() {
    println(eval(Sum(Sum(Num(3), Num(2)), Num(4))))
}