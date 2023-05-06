package fpwithkotlin.ch4.sec1

// tag::init[1]
fun failingFn(i: Int): Int {
    val y: Int = throw Exception("boom") // <1>
    return try {
        val x = 42 + 5
        x + y
    } catch (e: Exception) {
        43 // <2>
    }
}// end::init[1]


// tag::init[2]
fun failingFn2(i: Int): Int = try {
    val x = 42 + 5
    x + (throw Exception("boom!")) as Int // <1>
} catch (e: Exception) {
    43 // <2>
}
// end::init[2]

fun main() {
    failingFn(12)
}