package fpwithkotlin.ch6

// begin::[1]
val rng = kotlin.random.Random
// end

// begin::[2]
fun rollDie(): Int {
    val rng = kotlin.random.Random
    return rng.nextInt(6)
}

fun rollDie2(rng: kotlin.random.Random): Int = rng.nextInt(6) // 반환값이 계속 바뀐다. 내부상태가 계속 변화한다.
// end


// begin::[3]
interface RNG {
    fun nextInt(): Pair<Int, RNG> // 내부 상태를 변경하는 대신에 난수와 새로운 상태를 함께 반환하는 식.
}

// end

// begin::[4]
data class SimpleRNG(val seed: Long) : RNG {
    override fun nextInt(): Pair<Int, RNG> {
        val newSeed =
            (seed * 0x5DEECE66DL + 0xBL) and
                    0xFFFFFFFFFFFL

        val nextRNG = SimpleRNG(newSeed)

        val n = (newSeed ushr 16).toInt()

        return n to nextRNG
    }
}
// end

// begin::[7]
typealias Rand<A> = (RNG) -> Pair<A, RNG>
// end


fun main() {
    val rng = SimpleRNG(42)
    val (n1, rng2) = rng.nextInt() // n1:16159453; rng2:SimpleRNG(seed=1059025964525)
    val (n2, rng3) = rng2.nextInt() // n2:-1281479697; rng3:SimpleRNG(seed=197491923327988)

    println(n1) // 16159453
    println(n1) // 16159453
    println(n1) // 16159453

    val intR: Rand<Int> = { it.nextInt() }
}


