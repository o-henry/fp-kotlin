package grokkingfp

/**
 * TODO
 * Requirements for the word ranking
 * The score of a given word is calculated by giving one point for each letter that is not an 'a'
 * For a given list of words, return a sorted list that starts with the highest-scoring word
 */

// ipt -> opt, transformation function

fun score(word: String): Int = word.replace("a", "").length
fun bonus(word: String): Int = if (word.contains("c")) 5 else 0
fun rankedWords(
    wordScore: (String) -> Int,
    words: List<String>,
): List<String> {
    return words.sortedBy(wordScore).reversed()
}

fun main() {
    val words = listOf("ada", "haskell", "scala", "java", "rust")

    val sortedWords = words.sortedBy(::score)
    val ranked = rankedWords(::score, words)

    val bonusRanked = rankedWords({ score(it) + bonus(it) }, words)


    println("words : $words")
    println("sorted words : $sortedWords")
    println("ranked: $ranked")
    println("bonus ranked: $bonusRanked")
}