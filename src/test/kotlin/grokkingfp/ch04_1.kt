package grokkingfp

val words = listOf("kotlin", "rust", "java")
fun score(word: String): Int = word.replace("a", "").length

fun main() {
    words.sortedBy { score(it) }
}