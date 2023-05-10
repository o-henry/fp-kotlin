package fromobjtofun

import kotlin.random.Random

/**
 * category compose to dot and arrow
 * In code, dots representing our types
 * arrows representing pure function
 */

fun <T> identity(a: T): T = a


/**
 * f::A -> C
 */
infix fun <A, B, C> ((A) -> B).andThen(f: (B) -> C): (A) -> C = { a: A -> f(this(a)) }

data class Holder<T>(private val value: T) {
    fun <U> transform(f: (T) -> U): Holder<U> = Holder(f(value))

    companion object {
        fun <T, U> lift(f: (T) -> U): (Holder<T>) -> Holder<U> = { c: Holder<T> ->
            c.transform(f)
        }
    }
}


fun main() {
    val a: Holder<String> = Holder("this is a string")
    val b1: Holder<Int> = a.transform(String::length)

    val strLenLifted = Holder.lift(String::length)
    val b2: Holder<Int> = strLenLifted(a)

    val a1 = a.transform(::identity)
    println(a == a1) // true
}