package grokkingfp

fun wordScores(wordScore: (String) -> Int, words: List<String>): List<Int> = words.map(wordScore)

fun highScoringWords(wordScore: (String) -> Int, words: List<String>): List<String> = words.filter { wordScore(it) > 1 }

fun highScoringWordsReturnAnotherFun(
    wordScore: (String) -> Int,
    words: List<String>,
): (Int) -> List<String> = { higherThen ->
    words.filter { word -> wordScore(word) > higherThen }
}


fun main() {
    // data
    val input = listOf<String>("ada", "haskell", "scala", "java", "rust")

    val filterIpt1 = listOf("scala", "rust", "ada")
    val filterIpt3 = listOf(5, 1, 2, 4, 0)


    // transformation
    val mappedLength = input.map { it.length }
    val numberOfS = input.map { it.length - it.replace("a", "").length }


    // output
    println("mappedLength : $mappedLength")
    println("highscored : ${highScoringWords({ score(it) + bonus(it) - penalty(it) }, input)}")

    println("filter1 : ${filterIpt1.filter { it.length < 5 }}")
    println("filter3 : ${filterIpt3.filter { it % 2 == 1 }}")


}