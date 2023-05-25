package fpwithkotlin.ch07

fun main() {
    val res = strToInt("10")
    when (res) {
        is Some<Int> -> {
            val res2 = double(res.value)
        }

        is None -> println("Error!")
    }



}

fun double(value: Int): Int = value * 2


sealed class Optional<out T> {
    companion object {
        @JvmStatic
        fun <T> lift(value: T): Optional<T> = Some(value)

        @JvmStatic
        fun <T> empty(): Optional<T> = None

    }
}

object None : Optional<Nothing>()
data class Some<T>(val value: T) : Optional<T>()


// use opt
fun strToInt(value: String): Optional<Int> = try {
    Optional.lift(value.toInt())
} catch (nfe: NumberFormatException) {
    Optional.empty()
}


typealias Fun<A, B> = (A) -> B

fun <A, B> Optional<A>.map(fn: Fun<A, B>): Optional<B> = when (this) {
    is None -> Optional.empty()
    is Some<A> -> Optional.lift(fn(value))
}

fun <A, B> Optional<A>.flatMap(
    fn: Fun<A, Optional<B>>,
): Optional<B> = when (this) {
    is None -> Optional.empty()
    is Some<A> -> {
        val res = fn(value)
        when (res) {
            is None -> Optional.empty()
            is Some<B> -> Optional.lift(res.value)
        }
    }
}